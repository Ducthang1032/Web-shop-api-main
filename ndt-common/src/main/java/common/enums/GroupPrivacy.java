package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum GroupPrivacy {
    PUBLIC("public"),
    PRIVATE("private");

    private String value;

    GroupPrivacy(String value) {
        this.value = value;
    }

    public static boolean isGroupPrivacy(String privacy) {
        return Arrays.stream(GroupPrivacy.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(privacy));
    }

    public static String formatValue(String value) {
        GroupPrivacy groupPrivacy = Arrays.stream(GroupPrivacy.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(groupPrivacy) ? groupPrivacy.getValue() : StringUtils.EMPTY;
    }

    public static boolean isPublic(String privacy) {
        return GroupPrivacy.PUBLIC.getValue().equalsIgnoreCase(privacy);
    }
}
