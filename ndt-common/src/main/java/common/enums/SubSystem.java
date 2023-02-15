package main.java.common.enums;

import lombok.Getter;

@Getter
public enum SubSystem {
    POEM(3L),
    CQ_STATION(1L);

    private final Long value;

    SubSystem(Long value) {
        this.value = value;
    }

    public static boolean isPoem(Long subSystem) {
        return POEM.getValue().equals(subSystem);
    }

    public static boolean isNotPoem(Long subSystem) {
        return !isPoem(subSystem);
    }

    public static boolean isCQStation(Long subSystem) {
        return CQ_STATION.getValue().equals(subSystem);
    }

    public static boolean isNotCQStation(Long subSystem) {
        return !isCQStation(subSystem);
    }
}