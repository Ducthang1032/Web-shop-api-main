package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum NotiAction {
    ON("on"),
    OFF("off");

    private final String value;

    NotiAction(String value) {
        this.value = value;
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(NotiAction.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
