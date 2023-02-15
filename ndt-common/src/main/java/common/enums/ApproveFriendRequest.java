package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ApproveFriendRequest {
    ACCEPT("accept"),
    DECLINE("decline");

    private final String value;

    ApproveFriendRequest(String value) {
        this.value = value;
    }

    public static boolean actionIsExist(String value) {
        return Arrays.stream(ApproveFriendRequest.values()).anyMatch(item -> item.getValue().equals(value));
    }
}
