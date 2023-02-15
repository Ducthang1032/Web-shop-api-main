package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SearchPostStatus {
    PENDING("pending"),
    REPORTED("reported"),
    HIDDEN("hidden"),
    ACTIVE("active");

    private final String status;

    SearchPostStatus(String status) {
        this.status = status;
    }

    public static boolean isSearchPostStatus(String status) {
        return Arrays.stream(SearchPostStatus.values()).anyMatch(sta -> sta.getStatus().equalsIgnoreCase(status));
    }

    public static boolean isNotSearchPortStatus(String status) {
        return !isSearchPostStatus(status);
    }

    public static boolean isSearchReportedPost(String status) {
        return SearchPostStatus.REPORTED.getStatus().equalsIgnoreCase(status);
    }

    public static boolean isSearchActivePost(String status) {
        return SearchPostStatus.ACTIVE.getStatus().equalsIgnoreCase(status);
    }
}
