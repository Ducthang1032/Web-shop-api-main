package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum HideAction {
    HIDE("hide"),
    UNHIDE("unhide");

    private final String value;

    HideAction(String value) {
        this.value = value;
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(HideAction.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean actionIsNotExist(String value) {
        return !actionIsExist(value);
    }

    public static boolean isHideAction(String value) {
        return HIDE.getValue().equalsIgnoreCase(value);
    }

    public static boolean isUnHideAction(String value) {
        return UNHIDE.getValue().equalsIgnoreCase(value);
    }
}
