package main.java.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@Getter
public enum PostOnWallPrivacy {
    FRIENDS("friends"),
    ONLY_ME("only me");

    private String value;

    PostOnWallPrivacy(String value) {
        this.value = value;
    }

    public static boolean valueIsExist(String value) {
        return Arrays.stream(PostOnWallPrivacy.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
