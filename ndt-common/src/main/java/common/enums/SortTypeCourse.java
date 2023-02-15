package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SortTypeCourse {
    NEWEST_FIRST("Newest first"),
    OLDEST_FIRST("Oldest first");

    private final String value;

    SortTypeCourse(String value) {
        this.value = value;
    }

    public static boolean isSortTypeCourse(String value) {
        return Arrays.stream(SortTypeCourse.values()).anyMatch(t -> t.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotSortType(String value) {
        return !isSortTypeCourse(value);
    }

    public static boolean isNewestFirst(String value) {
        return SortTypeCourse.NEWEST_FIRST.getValue().equalsIgnoreCase(value);
    }

}
