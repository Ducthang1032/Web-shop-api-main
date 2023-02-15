package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberRequestNoti {
    ON("on"),
    OFF("off");

    private String value;

    MemberRequestNoti(String value) {
        this.value = value;
    }

    public static boolean memberRequestNotiIsExist(String value) {
        return Arrays.stream(MemberRequestNoti.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}