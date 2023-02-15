package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum FriendType {
    PENDING("Pending"),
    FRIEND("Friend"),
    BLOCKED("Blocked"),
    CANCEL_REQUEST("Cancel request");

    private final String value;

    FriendType(String value) {
        this.value = value;
    }

    public static boolean friendTypeIsExist(String friendType) {
        return Arrays.stream(FriendType.values()).anyMatch(item -> item.value.equalsIgnoreCase(friendType));
    }
}
