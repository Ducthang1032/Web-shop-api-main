package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum SearchRoleAccount {
    ALL("all", "ALL"),
    ADMIN("admin", "ADMIN"),
    USER("user", "USER"),
    CONTENT_REVIEWER("content_reviewer", "CONTENT_REVIEWER");

    private String value;
    private String type;

    SearchRoleAccount(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public static boolean roleIsExist(String value) {
        return Arrays.stream(SearchRoleAccount.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static String searchRole(String role) {
        return Arrays.stream(SearchRoleAccount.values())
                .filter(itemValue -> itemValue.getValue().equalsIgnoreCase(role)).findFirst()
                .map(SearchRoleAccount::getType).orElse(StringUtils.EMPTY);

    }
}
