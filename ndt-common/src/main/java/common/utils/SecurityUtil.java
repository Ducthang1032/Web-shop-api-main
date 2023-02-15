package main.java.common.utils;

import com.tdt.cqsta.common.constants.AuthoritiesConstants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static com.tdt.cqsta.common.constants.CommonConstant.AUTH_KEY_CDN;
import static com.tdt.cqsta.common.constants.CommonConstant.SLASH;
import static io.undertow.util.Headers.X_FORWARDED_FOR;

public class SecurityUtil {

    public static String getClientIP(HttpServletRequest request) {
        try {
            if (Objects.isNull(request))
                return InetAddress.getLocalHost().getHostAddress();

            if (Objects.nonNull(request.getHeader(X_FORWARDED_FOR.toString())))
                return request.getHeader(X_FORWARDED_FOR.toString());

            return request.getRemoteAddr();
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * @param signingKey:    Cq1I783AvYgKb3rglLoeYbapo
     * @param cdnURL:        https://cqstation-cdn.cyberquote.com/
     * @param obsAccessPath: https://cqstation-cdn.cyberquote.com/test/video.mp4
     * @return: /test/video.mp4-1648277300-fe1ced26b351416491895f12093ad0c1-0-hsjf783AvYgKb3rglLoeYbHQO
     */
    public static String generateAuthKeyCDN(String signingKey, String cdnURL, String obsAccessPath) {
        try {
            if (StringUtils.isBlank(signingKey) || StringUtils.isBlank(obsAccessPath))
                return StringUtils.EMPTY;

            // https://cqstation-cdn.cyberquote.com/test/video.mp4 -> /test/video.mp4
            obsAccessPath = obsAccessPath.replace(cdnURL, StringUtils.EMPTY);
            if (!obsAccessPath.startsWith(SLASH)) obsAccessPath = SLASH.concat(obsAccessPath);

            String signingKeyTemplate = "%s-%s-%s-0-%s";
            String validityPeriod = Objects.toString(Instant.now().getEpochSecond(), StringUtils.EMPTY); // 1648277300
            String rand = UUID.randomUUID().toString().replace("-", StringUtils.EMPTY); // fe1ced26b351416491895f12093ad0c1
            String md5hash = DigestUtils.md5Hex(String.format(signingKeyTemplate, obsAccessPath, validityPeriod, rand, signingKey)).toLowerCase();

            String authKeyCDNTemplate = "%s-%s-0-%s";
            return String.format(authKeyCDNTemplate, validityPeriod, rand, md5hash);
        } catch (Exception ex) {
            return StringUtils.EMPTY;
        }
    }

    public static String getUrlResourceWithAuthKey(String urlResource, String signingKey, String cdnURL) {
        if (StringUtils.isBlank(urlResource)) return urlResource;
        if (StringUtils.containsIgnoreCase(urlResource, AUTH_KEY_CDN))
            urlResource = urlResource.substring(NumberUtils.INTEGER_ZERO,
                    StringUtils.indexOfIgnoreCase(urlResource, AUTH_KEY_CDN));

        return urlResource.concat(AUTH_KEY_CDN)
                .concat(SecurityUtil.generateAuthKeyCDN(signingKey, cdnURL, urlResource));
    }

    public static String getUrlResourceWithAuthKey(String urlResource) {
        if (StringUtils.isBlank(urlResource)) return StringUtils.EMPTY;
        return urlResource.concat(AUTH_KEY_CDN).concat(AuthoritiesConstants.AUTH_KEY_CDN_DEFAULT);
    }
}
