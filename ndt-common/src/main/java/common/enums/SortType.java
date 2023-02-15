package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SortType {
    MOST_REPORTED_FIRST("Most reported first"),
    NEWEST_FIRST("Newest first"),
    OLDEST_FIRST("Oldest first");

    private final String value;

    SortType(String value) {
        this.value = value;
    }

    public static boolean isSortType(String value) {
        return Arrays.stream(SortType.values()).anyMatch(t -> t.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotSortType(String value) {
        return !isSortType(value);
    }

    public static boolean isMostReportedFirst(String value) {
        return SortType.MOST_REPORTED_FIRST.getValue().equalsIgnoreCase(value);
    }

    public static boolean isOldestFirst(String value) {
        return SortType.OLDEST_FIRST.getValue().equalsIgnoreCase(value);
    }

    public static boolean isSortTypeForPinnedGroups(String value) {
        return isSortType(value) && !SortType.MOST_REPORTED_FIRST.getValue().equalsIgnoreCase(value);
    }
}
