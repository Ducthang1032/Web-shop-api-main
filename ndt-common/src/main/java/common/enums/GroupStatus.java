package main.java.common.enums;

import lombok.Getter;

@Getter
public enum GroupStatus {
    ACTIVE("active"),
    BLOCKED("blocked"),
    REPORTED("reported"),
    DELETED("deleted");

    private final String value;

    GroupStatus(String value) {
        this.value = value;
    }
}
