package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum MuteTime {
    HALF_DAY(0.5D, "Half day"),
    ONE_DAY(1D, "1 day"),
    THREE_DAY(3D, "3 days"),
    SEVEN_DAY(7D, "7 days"),
    FOURTEEN_DAY(14D, "14 days"),
    TWENTYEIGHT_DAY(28D, "28 days"),
    UNTIL_ADMIN_UNMUTES(999D, "Until Admin unmutes");

    private Double value;
    private String type;

    MuteTime(Double value, String type) {
        this.value = value;
        this.type = type;
    }

    public static boolean isMuteTime(Double muteTime) {
        return Objects.nonNull(muteTime)
                && (muteTime > UNTIL_ADMIN_UNMUTES.getValue()
                || Arrays.stream(MuteTime.values()).anyMatch(i -> i.getValue().equals(muteTime)));
    }
}