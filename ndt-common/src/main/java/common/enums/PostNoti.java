package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum PostNoti {
    ALL("all"),
    FRIENDS("friends"),
    OFF("off");

    private String value;

    PostNoti(String value) {
        this.value = value;
    }

    public static boolean postNotiIsExist(String value) {
        return Arrays.stream(PostNoti.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static String formatValue(String value) {
        PostNoti postNoti = Arrays.stream(PostNoti.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(postNoti) ? postNoti.getValue() : StringUtils.EMPTY;
    }
}