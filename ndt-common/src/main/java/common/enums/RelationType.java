package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RelationType {
    FRIEND("friend"),
    FOLLOWER("follower"),
    FOLLOWING("following"),
    FAVORITE("favorite"),
    MUTUAL_FRIENDS("mutual_friends"),
    BLOCKED("blocked");

    private final String value;

    RelationType(String value) {
        this.value = value;
    }

    public static boolean relationTypeIsExist(String relation) {
        return Arrays.stream(RelationType.values()).anyMatch(item -> item.value.equalsIgnoreCase(relation));
    }
}
