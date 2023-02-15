package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Theme {
    CQ_THEME("cq_theme"),
    LIGHT("light_theme"),
    DARK("dark_theme");

    private final String value;

    Theme(String value) {
        this.value = value;
    }

    public static boolean isThemeExist(String value) {
        return Arrays.stream(Theme.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static Theme fromValue(String value) {
        return Arrays.stream(Theme.values())
                .filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }

}
