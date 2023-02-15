package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CQGender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String value;

    CQGender(String value) {
        this.value = value;
    }

    public static String getGender(String gender) {
        for (CQGender cqGender : CQGender.values()) {
            if (cqGender.value.equalsIgnoreCase(gender))
                return cqGender.value;
        }
        return OTHER.value;
    }

    public static boolean genderIsNotExist(String gender) {
        return Arrays.stream(CQGender.values()).noneMatch(item -> item.value.equalsIgnoreCase(gender));
    }
}
