package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CommentStatus {
    ACTIVE("active"),
    REPORTED("reported"),
    HIDDEN("hidden"),
    REMOVED("removed");

    private final String value;

    CommentStatus(String value) {
        this.value = value;
    }

    public static boolean isActiveOrReported(String value) {
        return Arrays.asList(ACTIVE.getValue(), REPORTED.getValue()).contains(value);
    }

    public static boolean isNotActiveAndReported(String value) {
        return !isActiveOrReported(value);
    }

    public static boolean isRemoved(String value) {
        return REMOVED.getValue().equals(value);
    }

    public static boolean isNotRemoved(String value) {
        return !isRemoved(value);
    }

    public static boolean isExist(String value) {
        return Arrays.stream(CommentStatus.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotExist(String value) {
        return !isExist(value);
    }

    public static boolean isHidden(String value) {
        return HIDDEN.getValue().equals(value);
    }

    public static boolean isNotHidden(String value) {
        return !isHidden(value);
    }
}
