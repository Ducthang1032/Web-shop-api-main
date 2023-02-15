package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum LMSInvoiceStatus {

    PENDING("pending"),
    PAID_OFF("paidoff"),
    CANCEL("cancel"),
    CONFIRM("confirm");

    private final String value;

    LMSInvoiceStatus(String value) {
        this.value = value;
    }

    public static boolean lmsInvoiceStatusIsExist(String value) {
        return Arrays.stream(LMSInvoiceStatus.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean lmsInvoiceStatusIsNotExist(String value) {
        return !lmsInvoiceStatusIsExist(value);
    }
}