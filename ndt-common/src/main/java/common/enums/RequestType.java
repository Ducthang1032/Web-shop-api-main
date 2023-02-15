package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RequestType {
    FRIEND_REQUEST("friend_request"),
    SENT_REQUEST("sent_request");

    private String value;

    RequestType(String value) {
        this.value = value;
    }

    public static boolean RequestTypeExist(String value) {
        return Arrays.stream(RequestType.values()).anyMatch(i -> i.getValue().equalsIgnoreCase(value));
    }
}