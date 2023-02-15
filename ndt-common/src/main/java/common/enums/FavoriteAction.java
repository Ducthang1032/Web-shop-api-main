package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum FavoriteAction {
    ADD("add"),
    REMOVE("remove");

    private String value;

    FavoriteAction(String value) {
        this.value = value;
    }

    public static boolean isFavoriteActionExist(String value) {
        return Arrays.stream(FavoriteAction.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

}