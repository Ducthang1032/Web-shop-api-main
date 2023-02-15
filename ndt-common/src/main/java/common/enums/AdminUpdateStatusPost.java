package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum AdminUpdateStatusPost {
    MAKE_AVAILABLE("make_available", "active"),
    HIDE("hide", "hidden");

    private final String action;
    private final String newStatus;

    AdminUpdateStatusPost(String action, String newStatus) {
        this.action = action;
        this.newStatus = newStatus;
    }

    public static boolean isAction(String action) {
        return Arrays.stream(AdminUpdateStatusPost.values())
                .anyMatch(item -> item.getAction().equalsIgnoreCase(action));
    }

    public static boolean isNotAction(String action) {
        return !isAction(action);
    }

    public static String getStatusByAction(String action) {
        return Arrays.stream(AdminUpdateStatusPost.values()).filter(item -> item.getAction().equalsIgnoreCase(action))
                .findFirst().map(AdminUpdateStatusPost::getNewStatus).orElse(StringUtils.EMPTY);
    }

    public static boolean isHide(String action) {
        return AdminUpdateStatusPost.HIDE.getAction().equalsIgnoreCase(action);
    }

    public static boolean isMakeAvailable(String action) {
        return AdminUpdateStatusPost.MAKE_AVAILABLE.getAction().equalsIgnoreCase(action);
    }
}
