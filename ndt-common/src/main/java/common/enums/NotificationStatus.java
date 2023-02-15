package main.java.common.enums;

import lombok.Getter;

@Getter
public enum NotificationStatus {
    ACTIVE("active"),
    DELETED("deleted");

    private String value;

    NotificationStatus(String value) {
        this.value = value;
    }
}

