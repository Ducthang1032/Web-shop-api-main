package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ResourceType {
    FILES("file"),
    VIDEOS("video"),
    IMAGES("image"),
    ALL("all"),
    MEDIA("media");
    private final String value;

    ResourceType(String value) {
        this.value = value;
    }

    public static boolean resourceTypeNotExist(String value) {
        return Arrays.stream(ResourceType.values()).noneMatch(item -> item.getValue().equalsIgnoreCase(value));
    }

    public static boolean isImage(ResourceType resourceType) {
        return IMAGES.equals(resourceType);
    }

    public static boolean isVideo(ResourceType resourceType) {
        return VIDEOS.equals(resourceType);
    }

    public static boolean isImageOrVideo(ResourceType resourceType) {
        return isImage(resourceType) || isVideo(resourceType);
    }

    public static boolean isNotImageAndVideo(ResourceType resourceType) {
        return !isImageOrVideo(resourceType);
    }

    public static boolean isFile(String value) {
        return value.equals(ResourceType.FILES.getValue());
    }

    public static boolean isMedia(String value) {
        return value.equals(ResourceType.MEDIA.getValue());
    }
}
