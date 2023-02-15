package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ChannelTypeSPhoton {
    DIRECT_MESSAGE("D"),
    REQUEST_MESSAGE("R"),
    PRIVATE_GROUP("P"),
    OPEN_GROUP("O");

    private final String type;

    ChannelTypeSPhoton(String type) {
        this.type = type;
    }

    public static boolean isNotDirectAndRequestMessage(String type) {
        return !isDirectOrRequestMessage(type);
    }

    public static boolean isDirectOrRequestMessage(String type) {
        return DIRECT_MESSAGE.getType().equalsIgnoreCase(type)
                || REQUEST_MESSAGE.getType().equalsIgnoreCase(type);
    }

    public static boolean isPrivate(String type) {
        return PRIVATE_GROUP.getType().equalsIgnoreCase(type);
    }

}
