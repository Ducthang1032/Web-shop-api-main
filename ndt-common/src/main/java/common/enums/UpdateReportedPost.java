package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UpdateReportedPost {
    KEEP("keep", "active"),
    REMOVE("remove", "hidden");

    private final String value;
    private final String type;

    UpdateReportedPost(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(UpdateReportedPost.values()).anyMatch(item -> item.getValue().equals(value));
    }

}
