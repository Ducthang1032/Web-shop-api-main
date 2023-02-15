package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum Visible {
    VISIBLE("visible", "Anyone can find this group"),
    HIDDEN("hidden", "Only members and invited people can find this group");

    private String value;
    private String type;

    Visible(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public static boolean isVisible(String visible) {
        return Arrays.stream(Visible.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(visible));
    }

    public static String formatValue(String value) {
        Visible visible = Arrays.stream(Visible.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(visible) ? visible.getValue() : StringUtils.EMPTY;
    }
}
