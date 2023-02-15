package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ManagementModule {
    ACTIVITY_MANAGEMENT("activity management"),
    USER_MANAGEMENT("user management"),
    SETTING_MANAGEMENT("setting management"),
    GROUP_MANAGEMENT("group management"),
    CONTENT_MANAGEMENT("content management"),
    NOTIFICATION_MANAGEMENT("notification management");

    private String value;

    ManagementModule(String value) {
        this.value = value;
    }

    public static boolean isManagementModuleExist(String value) {
        return Arrays.stream(ManagementModule.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

}