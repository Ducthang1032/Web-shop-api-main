package main.java.common.enums;

import lombok.Getter;

@Getter
public enum CQLmsModuleType {
    CERTIFICATE("certificate"),
    URL("url"),
    PAGE("page");

    private final String value;

    CQLmsModuleType(String value) {
        this.value = value;
    }

    public static boolean isCertificate(String value) {
        return CQLmsModuleType.CERTIFICATE.getValue().equalsIgnoreCase(value);
    }
}