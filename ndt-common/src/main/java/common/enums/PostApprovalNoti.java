package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PostApprovalNoti {
    ON("on"),
    OFF("off");

    private String value;

    PostApprovalNoti(String value) {
        this.value = value;
    }

    public static boolean postApprovalNotiIsExist(String value) {
        return Arrays.stream(PostApprovalNoti.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean convertPostApprovalNoti(String value) {
        return PostApprovalNoti.ON.getValue().equals(value);
    }
}
