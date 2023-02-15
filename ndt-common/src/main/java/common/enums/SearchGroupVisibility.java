package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum SearchGroupVisibility {
    ALL("all"),
    VISIBLE("visible"),
    HIDDEN("hidden");

    private final String value;

    SearchGroupVisibility(String value) {
        this.value = value;
    }

    public static boolean isExist(String value) {
        return Arrays.stream(SearchGroupVisibility.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotExist(String value) {
        return !isExist(value);
    }

    public static List<String> getListVisibility(String value) {
        List<String> correctVisibilityList = Arrays.asList(VISIBLE.getValue(), HIDDEN.getValue());
        if (ALL.getValue().equalsIgnoreCase(value))
            return correctVisibilityList;
        return correctVisibilityList.stream().filter(item -> item.equalsIgnoreCase(value)).collect(Collectors.toList());
    }
}
