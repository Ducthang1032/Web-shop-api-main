package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum VoucherType {
    AVAILABLE_VOUCHER("available_voucher"),
    YOUR_VOUCHER("your_voucher");

    private final String value;

    VoucherType(String value) {
        this.value = value;
    }

    public static boolean voucherTypeIsExist(String value) {
        return Arrays.stream(VoucherType.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean voucherTypeIsNotExist(String value) {
        return !voucherTypeIsExist(value);
    }

    public static boolean isYourVoucherType(String value) {
        return StringUtils.equalsIgnoreCase(value, YOUR_VOUCHER.value);
    }
}
