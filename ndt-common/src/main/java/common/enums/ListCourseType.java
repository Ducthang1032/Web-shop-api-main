package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum ListCourseType {

    PUBLIC_COURSE("public_course"),
    OWNED_COURSE("owned_course");

    private final String value;

    ListCourseType(String value) {
        this.value = value;
    }

    public static boolean listCourseTypeNotExist(String value) {
        return Arrays.stream(ListCourseType.values())
                .noneMatch(item -> item.getValue().equalsIgnoreCase(StringUtils.trimToEmpty(value)));
    }
}
