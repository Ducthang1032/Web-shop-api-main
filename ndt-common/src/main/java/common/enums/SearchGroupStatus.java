package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum SearchGroupStatus {
    ALL("all"),
    ACTIVE("active"),
    BLOCKED("blocked"),
    REPORTED("reported");

    private final String value;

    SearchGroupStatus(String value) {
        this.value = value;
    }

    public static boolean isExist(String value) {
        return Arrays.stream(SearchGroupStatus.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isNotExist(String value) {
        return !isExist(value);
    }

    public static List<String> getListStatusSearch(String value) {
        List<String> correctPrivacyList = Arrays.asList(ACTIVE.getValue(), BLOCKED.getValue(),
                REPORTED.getValue());
        if (ALL.getValue().equalsIgnoreCase(value))
            return correctPrivacyList;
        return correctPrivacyList.stream().filter(item -> item.equalsIgnoreCase(value)).collect(Collectors.toList());
    }

    public static boolean isSearchReportedGroup(String value) {
        return SearchGroupStatus.REPORTED.getValue().equalsIgnoreCase(value);
    }
}
