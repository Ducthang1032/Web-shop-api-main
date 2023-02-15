package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum PostPrivacy {
    PUBLIC("public"),
    PRIVATE("private"),
    ONLY_ME("only me"),
    ONLY_FRIENDS("friends only");
    private final String value;

    PostPrivacy(String value) {
        this.value = value;
    }

    public static boolean isFriendsOnly(String postPrivacy) {
        return StringUtils.equalsIgnoreCase(postPrivacy, ONLY_FRIENDS.getValue());
    }
}
