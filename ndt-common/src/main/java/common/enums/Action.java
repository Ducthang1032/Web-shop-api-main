package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Action {
    DO("do"),
    UNDO("undo");

    private String value;

    Action(String value) {
        this.value = value;
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(Action.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isDoAction(String value) {
        return DO.getValue().equalsIgnoreCase(value);
    }

    public static boolean isUndoAction(String value) {
        return UNDO.getValue().equalsIgnoreCase(value);
    }
}