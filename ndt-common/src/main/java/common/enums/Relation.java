package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Relation {
    FRIEND("friend"),
    FOLLOWING("following");

    private String value;

    Relation(String value) {
        this.value = value;
    }

    public static boolean relationIsExist(String value) {
        return Arrays.stream(Relation.values()).anyMatch(item -> item.value.equalsIgnoreCase(value));
    }
}