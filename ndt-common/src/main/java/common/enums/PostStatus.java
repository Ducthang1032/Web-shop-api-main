package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PostStatus {
    PENDING("pending"),
    REPORTED("reported"),
    HIDDEN("hidden"),
    REMOVED("removed"),
    ACTIVE("active");

    private String value;

    PostStatus(String value) {
        this.value = value;
    }

    public static boolean valueIsExist(String value) {
        return Arrays.stream(PostStatus.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isReported(String status) {
        return PostStatus.REPORTED.getValue().equalsIgnoreCase(status);
    }
}
