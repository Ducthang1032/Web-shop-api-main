package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum MyCourseStatus {
    UNATTEMPTED("unattempted"),
    INPROCESS("inprocess"),
    COMPLETED("completed");

    private final String status;

    MyCourseStatus(String status) {
        this.status = status;
    }

    public static boolean isCourseStatus(String status) {
        return Arrays.stream(MyCourseStatus.values()).anyMatch(sta -> sta.getStatus().equalsIgnoreCase(status));
    }

    public static boolean isNotCourseStatus(String status) {
        return !isCourseStatus(status);
    }
}
