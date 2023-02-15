package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum CQLmsLoginType {
    LOGIN_FIRST_TIME("login_first_time"),
    SWITCH_ACCOUNT("switch_account"),
    LOGIN_AGAIN("login_again");

    private final String value;

    CQLmsLoginType(String value) {
        this.value = value;
    }

    public static boolean loginTypeIsExist(String value) {
        return Arrays.stream(CQLmsLoginType.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean loginTypeIsNotExist(String value) {
        return !loginTypeIsExist(value);
    }

    public static boolean isSwitchAccount(String value) {
        return StringUtils.containsIgnoreCase(value, SWITCH_ACCOUNT.value);
    }

    public static boolean isLoginFirstTime(String value) {
        return StringUtils.containsIgnoreCase(value, LOGIN_FIRST_TIME.value);
    }

    public static boolean isLoginFirstTimeOrSwitchAccount(String value) {
        return isSwitchAccount(value) || isLoginFirstTime(value);
    }

    public static boolean isLoginAgain(String value) {
        return StringUtils.containsIgnoreCase(value, LOGIN_AGAIN.value);
    }

}
