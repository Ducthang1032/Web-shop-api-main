package main.java.common.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("active"),
    DUMMY_P3("dummy_p3"),
    BLOCKED("blocked"),
    REMOVED("removed");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    public static boolean isNotActive(String status) {
        return !isActive(status);
    }

    public static boolean isActive(String status) {
        return ACTIVE.getValue().equalsIgnoreCase(status);
    }

    public static boolean isDummyP3(String status) {
        return DUMMY_P3.getValue().equalsIgnoreCase(status);
    }

    public static boolean isNotDummyP3(String status) {
        return !isDummyP3(status);
    }
}
