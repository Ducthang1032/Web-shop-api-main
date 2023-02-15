package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum SearchAccountStatus {
    ALL("all"),
    ACTIVE("active"),
    REPORTED("reported"),
    BLOCKED("blocked"),
    REMOVED("removed");

    private final String value;

    SearchAccountStatus(String value) {
        this.value = value;
    }

    public static boolean statusIsExist(String value) {
        return Arrays.stream(SearchAccountStatus.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isReported(String value) {
        return REPORTED.getValue().equalsIgnoreCase(value);
    }

    public static boolean isActive(String value) {
        return ACTIVE.getValue().equalsIgnoreCase(value);
    }

    public static boolean isActiveOrReported(String value) {
        return isActive(value) || isReported(value);
    }

    public static boolean isNotActiveAndReported(String value) {
        return !isActiveOrReported(value);
    }

    public static List<String> getListSearchStatus(String status) {
        if (SearchAccountStatus.ALL.value.equalsIgnoreCase(status))
            return Stream.of(ACTIVE, BLOCKED, REMOVED).map(SearchAccountStatus::getValue).collect(Collectors.toList());

        if (isReported(status))
            return Stream.of(ACTIVE).map(SearchAccountStatus::getValue).collect(Collectors.toList());

        return Arrays.stream(SearchAccountStatus.values())
                .map(SearchAccountStatus::getValue)
                .filter(staValue -> staValue.equalsIgnoreCase(status)).collect(Collectors.toList());
    }

}
