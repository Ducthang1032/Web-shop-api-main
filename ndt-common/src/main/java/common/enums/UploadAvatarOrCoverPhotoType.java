package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UploadAvatarOrCoverPhotoType {
    AVATAR("avatar"),
    COVER_PHOTO("cover_photo");

    private final String value;

    UploadAvatarOrCoverPhotoType(String value) {
        this.value = value;
    }

    public static boolean typeIsNotExist(String value) {
        return Arrays.stream(UploadAvatarOrCoverPhotoType.values()).noneMatch(item -> item.getValue().equals(value));
    }
}
