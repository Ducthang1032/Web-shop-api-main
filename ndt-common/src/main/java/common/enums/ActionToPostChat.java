package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionToPostChat {
    PIN("pin"),
    UNPIN("unpin");

    private final String value;

    ActionToPostChat(String value) {
        this.value = value;
    }
}
