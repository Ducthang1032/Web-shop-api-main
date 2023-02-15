package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PermissionSetup {
    CREATE("create"),
    UPDATE("update"),
    VIEW("view"),
    DELETE("delete");

    private String value;

    PermissionSetup(String value) {
        this.value = value;
    }

    public static boolean isPermissionSetupExist(String value) {
        return Arrays.stream(PermissionSetup.values()).anyMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

}