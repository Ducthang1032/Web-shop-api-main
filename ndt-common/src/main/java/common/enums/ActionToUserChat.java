package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionToUserChat {
    ADD("add"),
    REMOVE("remove");

    private final String value;

    ActionToUserChat(String value) {
        this.value = value;
    }
}