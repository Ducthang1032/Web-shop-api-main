package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum FollowingType {
    FOLLOW("follow"),
    UNFOLLOW("unFollow");

    private final String value;

    FollowingType(String value) {
        this.value = value;
    }

    public static boolean isFollowingTypeExist(String type) {
        return Arrays.stream(FollowingType.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(type));
    }
}
