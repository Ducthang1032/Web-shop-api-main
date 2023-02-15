package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ActionAdminRedeemVoucher {
    REDEEM("redeem"),
    CANCEL("cancel");

    private final String value;

    ActionAdminRedeemVoucher(String value) {
        this.value = value;
    }

    public static boolean isActionExist(String action) {
        return Arrays.stream(ActionAdminRedeemVoucher.values())
                .anyMatch(item -> item.getValue().equalsIgnoreCase(action));
    }

    public static boolean isActionNotExist(String action) {
        return !isActionExist(action);
    }

    public static boolean isRedeem(String action) {
        return REDEEM.getValue().equalsIgnoreCase(action);
    }
}