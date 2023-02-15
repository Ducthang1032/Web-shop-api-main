package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ActionWarnOrBlock {
    WARN("warn"),
    UNWARN("unwarn"),
    BLOCK("block"),
    UNBLOCK("unblock");

    private final String value;

    ActionWarnOrBlock(String value) {
        this.value = value;
    }

    public static boolean actionWarnOrBlockIsExist(String value) {
        return Arrays.stream(ActionWarnOrBlock.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
