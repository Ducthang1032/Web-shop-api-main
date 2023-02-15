package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ActivityType {
    CONTENT_MANAGEMENT("Content Management"),
    USER_MANAGEMENT("User Management"),
    GROUP_MANAGEMENT("Group Management"),
    NOTIFICATION_MANAGEMENT("Notification Management"),
    ACTIVITY_MANAGEMENT("Activity Management"),
    SETTING_MANAGEMENT("Setting Management"),
    CQTV_MANAGEMENT("CQTV Management");

    private String value;

    ActivityType(String value) {
        this.value = value;
    }

    public static boolean activityTypeIsNotExist(String reaction) {
        return Arrays.stream(ActivityType.values()).noneMatch(item -> item.value.equalsIgnoreCase(reaction));
    }
}
