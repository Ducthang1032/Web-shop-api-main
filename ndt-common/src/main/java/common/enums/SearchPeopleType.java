package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SearchPeopleType {
    FOLLOWING("following"),
    ALL("all"),
    FRIEND("friends");

    private final String value;

    SearchPeopleType(String value) {
        this.value = value;
    }

    public static boolean searchPeopleTypeIsExist(String value) {
        return Arrays.stream(SearchPeopleType.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
