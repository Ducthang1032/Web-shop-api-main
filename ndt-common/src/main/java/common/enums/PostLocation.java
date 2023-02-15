package main.java.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@Getter
public enum PostLocation {
    USER("user"),
    GROUP("group");

    private String value;

    PostLocation(String value) {
        this.value = value;
    }

    public static boolean valueIsExist(String value) {
        return Arrays.stream(PostLocation.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
