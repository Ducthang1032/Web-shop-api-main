package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum RightToPost {
    EVERYONE("everyone", "everyone in group can post"),
    ADMIN("admin", "Only admin can post");

    private String value;
    private String type;

    RightToPost(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public static boolean isRightToPost(String rightToPost) {
        return Arrays.stream(RightToPost.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(rightToPost));
    }

    public static String formatValue(String value) {
        RightToPost rightToPost = Arrays.stream(RightToPost.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(rightToPost) ? rightToPost.getValue() : StringUtils.EMPTY;
    }
}
