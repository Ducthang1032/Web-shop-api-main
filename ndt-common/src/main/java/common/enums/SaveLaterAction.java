package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SaveLaterAction {
    SAVE("save"),
    UN_SAVE("unsave");

    private final String value;

    SaveLaterAction(String value) {
        this.value = value;
    }

    public static boolean isActionExist(String action) {
        return Arrays.stream(SaveLaterAction.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(action));
    }
}