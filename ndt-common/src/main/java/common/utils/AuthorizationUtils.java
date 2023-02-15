package main.java.common.utils;

import com.tdt.cqsta.common.constants.AuthoritiesConstants;
import com.tdt.cqsta.common.enums.RoleAccount;
import org.springframework.util.CollectionUtils;

import java.util.List;

public final class AuthorizationUtils {

    public static String getRole(List<String> authorities) {
        if (CollectionUtils.isEmpty(authorities) || !authorities.get(0).startsWith(AuthoritiesConstants.ROLE_PREFIX))
            return RoleAccount.USER.getName();
        return authorities.get(0).substring(AuthoritiesConstants.ROLE_PREFIX.length());
    }
}
