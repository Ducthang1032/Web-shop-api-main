package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum PoemUserCategoryCd {
    Normal("Normal"),
    Verified("Verified"),
    Staff("Staff"),
    TR("TR");

    private final String value;

    PoemUserCategoryCd(String value) {
        this.value = value;
    }

    public static boolean isCategoryCdExist(String value) {
        return Arrays.stream(PoemUserCategoryCd.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isCategoryCdNotExist(String value) {
        return !isCategoryCdExist(value);
    }

    public static boolean isTR(String value) {
        return PoemUserCategoryCd.TR.getValue().equalsIgnoreCase(value);
    }

    public static boolean isVerified(String value) {
        return PoemUserCategoryCd.Verified.getValue().equalsIgnoreCase(value);
    }

    public static String formatCategoryCd(String value) {
        return Arrays.stream(PoemUserCategoryCd.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value))
                .findFirst()
                .map(PoemUserCategoryCd::getValue).orElse(StringUtils.EMPTY);
    }
}
