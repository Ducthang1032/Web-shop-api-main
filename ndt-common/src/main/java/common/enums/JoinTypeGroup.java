package main.java.common.enums;

import lombok.Getter;

@Getter
public enum JoinTypeGroup {
    JOIN("join"),
    LEAVE("leave");

    private String value;

    JoinTypeGroup(String value) {
        this.value = value;
    }
}
