package main.java.common.utils;

import com.tdt.cqsta.common.constants.RegexConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PasswordUtils {
    public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile(RegexConstants.PASSWORD_REGEX);

    public static boolean isPassword(final String emailStr) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(emailStr);
        return matcher.find();
    }

}
