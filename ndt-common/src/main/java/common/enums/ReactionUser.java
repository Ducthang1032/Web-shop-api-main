package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum ReactionUser {
    LIKE("like"),
    ANGRY("angry"),
    LOVE("love"),
    SAD("sad"),
    CARE("care"),
    WOW("wow"),
    HAHA("haha");

    private final String value;

    ReactionUser(String value) {
        this.value = value;
    }

    public static boolean reactionIsExist(String reaction) {
        return Arrays.stream(ReactionUser.values()).anyMatch(item -> item.value.equalsIgnoreCase(reaction));
    }

    public static String formatValue(String value) {
        ReactionUser reactionUser = Arrays.stream(ReactionUser.values())
                .filter(item -> item.value.equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(reactionUser) ? reactionUser.getValue() : StringUtils.EMPTY;
    }
}