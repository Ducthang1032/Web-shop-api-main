package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum SearchGroupPrivacy {
    ALL("all"),
    PUBLIC("public"),
    PRIVATE("private");

    private final String value;

    SearchGroupPrivacy(String value) {
        this.value = value;
    }

    public static boolean isExist(String value) {
        return Arrays.stream(SearchGroupPrivacy.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotExist(String value) {
        return !isExist(value);
    }

    public static List<String> getListPrivacySearch(String value) {
        List<String> correctPrivacyList = Arrays.asList(PUBLIC.getValue(), PRIVATE.getValue());
        if (ALL.getValue().equalsIgnoreCase(value))
            return correctPrivacyList;
        return correctPrivacyList.stream().filter(item -> item.equalsIgnoreCase(value)).collect(Collectors.toList());
    }
}
