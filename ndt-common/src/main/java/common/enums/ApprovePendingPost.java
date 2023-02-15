package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ApprovePendingPost {
    APPROVE("approve", "active"),
    DECLINE("decline", "hidden");

    private final String value;
    private final String type;

    ApprovePendingPost(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public static ApprovePendingPost fromValue(String value) {
        return Arrays.stream(ApprovePendingPost.values())
                .filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(ApprovePendingPost.values()).anyMatch(item -> item.getValue().equals(value));
    }

}
