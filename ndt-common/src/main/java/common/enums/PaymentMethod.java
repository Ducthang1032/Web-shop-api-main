package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PaymentMethod {

    PAY_NOW("PayNow"),

    VISA_MASTER_CARD("VISA/MASTER CARD");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public static boolean isPaymentMethodExist(String value) {
        return Arrays.stream(PaymentMethod.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }
}
