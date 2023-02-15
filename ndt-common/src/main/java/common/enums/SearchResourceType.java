package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum SearchResourceType {
    ALL("all"),
    FILE("file"),
    VIDEO("video"),
    IMAGE("image");
    private final String type;

    SearchResourceType(String type) {
        this.type = type;
    }

    public static String formatType(String type) {
        return Arrays.stream(SearchResourceType.values())
                .filter(item -> item.getType().equalsIgnoreCase(type))
                .findFirst().map(SearchResourceType::getType).orElse(StringUtils.EMPTY);
    }

    public static boolean isAll(String type) {
        return ALL.getType().equalsIgnoreCase(type);
    }
}
