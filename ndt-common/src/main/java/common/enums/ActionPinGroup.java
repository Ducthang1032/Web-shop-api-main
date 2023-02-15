package main.java.common.enums;

import lombok.Getter;
import java.util.Arrays;

@Getter
public enum ActionPinGroup {
    PIN("pin"),
    UNPIN("unpin");

    private final String value;

    ActionPinGroup(String value) {
        this.value = value;
    }

    public static boolean actionPinIsExist(String value) {
        return Arrays.stream(ActionPinGroup.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isPinGroup(String value) {
        return PIN.getValue().equalsIgnoreCase(value);
    }

    public static boolean isUnPinGroup(String value) {
        return UNPIN.getValue().equalsIgnoreCase(value);
    }
}

