package main.java.common.utils;

import com.tdt.cqsta.common.constants.CommonConstant;
import com.tdt.cqsta.common.constants.NumberConstants;
import com.tdt.cqsta.common.enums.SubSystem;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.springframework.http.ContentDisposition;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.tdt.cqsta.common.constants.CommonConstant.CONTENT_DISPOSITION_INLINE;
import static com.tdt.cqsta.common.constants.CommonConstant.REPLACEMENT_FILE_NAME_IN_CONTENT_DISPOSITION;
import static com.tdt.cqsta.common.constants.NumberConstants.MIN_HASHTAG_LENGTH_OF_POEM;
import static com.tdt.cqsta.common.constants.RegexConstants.*;

public final class StringUtils {
    /**
     * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace only
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is
     * not empty and not null and not whitespace only
     * @since 2.0
     * @since 3.0 Changed signature from isNotBlank(String) to isNotBlank(CharSequence)
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    public static Set<String> getASetHashtag(String content, Long subSystem) {
        Set<String> result = new HashSet<>();
        if (org.apache.commons.lang3.StringUtils.isBlank(content))
            return result;
        boolean isNotPoem = SubSystem.isNotPoem(subSystem);
        String regexHashtag = isNotPoem ? HASHTAG_REGEX : HASHTAG_REGEX_POEM;
        Pattern pattern = Pattern.compile(regexHashtag);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            if (isNotPoem || (matcher.group().length() >= MIN_HASHTAG_LENGTH_OF_POEM))
                result.add(matcher.group());
        }

        return result;
    }

    /**
     * @param content ex: This is content of https://google.com, https://facebook.com
     * @return [https://google.com, https://facebook.com]
     */
    public static List<String> getContentByRegex(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        List<String> contents = new ArrayList<>();
        while (matcher.find())
            contents.add(matcher.group());
        return contents;
    }

    /**
     * @param compareString ex:"Quang Anh"
     * @param source        ex:"Quang Anh is a cute boy"
     * @return true
     */
    public static boolean isContainKeySensitive(String compareString, String source) {
        if (StringUtils.isBlank(compareString)) return true;
        if (StringUtils.isBlank(source)) return false;
        return Pattern.compile(Pattern.quote(compareString.trim()), Pattern.CASE_INSENSITIVE).matcher(source).find();

    }

    public static List<String> getTopThreeWorkFromList(List<String> sourceList) {
        if (CollectionUtils.isEmpty(sourceList)) return new ArrayList<>();
        List<Map.Entry<String, Long>> workAndCount = sourceList.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        Collections.reverse(workAndCount);
        return workAndCount
                .subList(NumberUtils.INTEGER_ZERO, Math.min(NumberConstants.MAX_REACTION_TYPE, workAndCount.size()))
                .stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static Map<String, String> getFirstIframeInfo(String html) {
        if (org.apache.commons.lang3.StringUtils.isBlank(html))
            return new HashMap<>();
        Element firstIframe = Jsoup.parse(html).select(CommonConstant.IFRAME).first();
        if (Objects.isNull(firstIframe))
            return new HashMap<>();
        return firstIframe.attributes().asList().stream()
                .collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
    }

    public static String getFileNameFromContentDisposition(ContentDisposition contentDisposition) {
        if (Objects.isNull(contentDisposition)) return org.apache.commons.lang3.StringUtils.EMPTY;
        return getFileNameFromContentDisposition(Objects.toString(contentDisposition));
    }

    public static String getFileNameFromContentDisposition(String contentDisposition) {
        if (org.apache.commons.lang3.StringUtils.isBlank(contentDisposition))
            return org.apache.commons.lang3.StringUtils.EMPTY;
        return contentDisposition.replaceFirst(
                FILE_NAME_IN_CONTENT_DISPOSITION_REGEX,
                REPLACEMENT_FILE_NAME_IN_CONTENT_DISPOSITION);
    }

    public static String createContentDispositionInline(String fileName) {
        fileName = org.apache.commons.lang3.StringUtils.trimToEmpty(fileName);
        return String.format(CONTENT_DISPOSITION_INLINE, fileName);
    }

    public static String createContentDispositionInline(ContentDisposition contentDisposition) {
        return createContentDispositionInline(getFileNameFromContentDisposition(contentDisposition));
    }

}
