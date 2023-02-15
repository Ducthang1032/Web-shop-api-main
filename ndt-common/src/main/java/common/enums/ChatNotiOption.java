package main.java.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ChatNotiOption {
    ALL("all"),
    MENTION("mention");

    private final String value;
}
