package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum NotificationPlatform {
    ANDROID("android", "android"),
    IOS("ios", "apple"),
    WEB("web", "web");

    private final String value;
    private final String deviceChatKey;

    NotificationPlatform(String value, String deviceChatKey) {
        this.value = value;
        this.deviceChatKey = deviceChatKey;
    }

    public static boolean isNotExist(String value) {
        return Arrays.stream(NotificationPlatform.values()).noneMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isIosPlatform(String value) {
        return NotificationPlatform.IOS.getValue().equalsIgnoreCase(value);
    }

    public static String getDeviceChatKey(String value) {
        return Arrays.stream(NotificationPlatform.values())
                .filter(item -> item.getValue().equalsIgnoreCase(value))
                .findFirst().map(NotificationPlatform::getDeviceChatKey).orElse(StringUtils.EMPTY);
    }
}
