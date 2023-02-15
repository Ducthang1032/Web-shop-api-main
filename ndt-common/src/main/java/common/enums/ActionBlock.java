package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ActionBlock {
    BLOCK("block"),
    UN_BLOCK("unblock");

    private final String value;

    ActionBlock(String value) {
        this.value = value;
    }

    public static boolean isActionExist(String action) {
        return Arrays.stream(ActionBlock.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(action));
    }

    public static boolean isBlockAction(String action) {
        return ActionBlock.BLOCK.getValue().equalsIgnoreCase(action);
    }
}
