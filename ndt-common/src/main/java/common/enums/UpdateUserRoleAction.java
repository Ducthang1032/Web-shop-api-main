package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UpdateUserRoleAction {
    ADD("add"),
    REMOVE("remove");

    private final String value;

    UpdateUserRoleAction(String value) {
        this.value = value;
    }

    public static boolean isUpdateUserRoleAction(String action) {
        return Arrays.stream(UpdateUserRoleAction.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(action));
    }

    public static boolean isNotUpdateUserRoleAction(String action) {
        return !isUpdateUserRoleAction(action);
    }
}
