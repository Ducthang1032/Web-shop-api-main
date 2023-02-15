package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReportLevel {
    REPORT_TO_ADMIN_GROUP("report to admin group"),
    REPORT_TO_ADMIN_CQ("report to admin CQ");

    private String value;

    ReportLevel(String value) {
        this.value = value;
    }

    public static boolean reportLevelIsExist(String value) {
        return Arrays.stream(ReportLevel.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean reportLevelIsNotExist(String value) {
        return !reportLevelIsExist(value);
    }

    public static boolean isReportToAdminCQ(String value) {
        return REPORT_TO_ADMIN_CQ.getValue().equalsIgnoreCase(value);
    }

    public static boolean isReportToAdminGroup(String value) {
        return REPORT_TO_ADMIN_GROUP.getValue().equalsIgnoreCase(value);
    }
}
