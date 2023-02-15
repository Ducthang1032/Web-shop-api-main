package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionSocial {
    AFFINITY("A"),
    WEIGHT("W"),
    LIKE("L"),
    DISLIKE("D"),
    COMMENT("C"),
    REMOVE_COMMENT("R"),
    SHARE("S"),
    REMOVE_SHARE("RS");

    private final String type;

    ActionSocial(String type) {
        this.type = type;
    }
}
