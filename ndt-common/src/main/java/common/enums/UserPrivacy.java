package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum UserPrivacy {
    PUBLIC("public"),
    ONLY_ME("only me"),
    ONLY_FRIENDS("friends only");

    private String value;

    UserPrivacy(String value) {
        this.value = value;
    }

    public static boolean isPrivacy(String privacy) {
        return Arrays.stream(UserPrivacy.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(privacy));
    }

    public static String formatPrivacy(String privacyPost) {
        UserPrivacy userPrivacy = Arrays.stream(UserPrivacy.values())
                .filter(item -> item.getValue().equalsIgnoreCase(privacyPost)).findFirst().orElse(null);
        return Objects.isNull(userPrivacy) ? StringUtils.EMPTY : userPrivacy.getValue();
    }
}
