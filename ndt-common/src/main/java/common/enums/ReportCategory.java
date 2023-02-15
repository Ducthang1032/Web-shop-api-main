package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReportCategory {
    POSTS("posts"),
    USERS("users"),
    COMMENTS("comments");

    private final String value;

    ReportCategory(String value) {
        this.value = value;
    }

    public static boolean isUsersReport(String status) {
        return USERS.getValue().equalsIgnoreCase(status);
    }

    public static boolean isPostsReport(String status) {
        return POSTS.getValue().equalsIgnoreCase(status);
    }

    public static boolean isCommentsReport(String status) {
        return COMMENTS.getValue().equalsIgnoreCase(status);
    }

    public static boolean isReportCategory(String value) {
        return Arrays.stream(ReportCategory.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotReportCategory(String value) {
        return !isReportCategory(value);
    }
}
