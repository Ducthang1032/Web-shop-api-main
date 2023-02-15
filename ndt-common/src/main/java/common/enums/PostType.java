package main.java.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum PostType {
    NORMAL("normal"),
    LIVESTREAM("livestream");

    private String value;

    PostType(String value) {
        this.value = value;
    }
}
