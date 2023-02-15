package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SearchPostType {
    VIDEO("video"),
    IMAGE("image"),
    FILE("file");

    private final String type;

    SearchPostType(String type) {
        this.type = type;
    }

    public static boolean isSearchPostType(String type) {
        return Arrays.stream(SearchPostType.values()).anyMatch(t -> t.getType().equalsIgnoreCase(type));
    }

    public static boolean isNotSearchPostType(String type) {
        return !isSearchPostType(type);
    }
}
