package main.java.common.enums;

import lombok.Getter;

@Getter
public enum TagLinkPreviewType {
    TITLE("title", "title", false),
    DESCRIPTION("description", "description", false),
    IMAGE("image", "image", false),
    OG_TITLE("og:title", "title", true),
    OG_DESCRIPTION("og:description", "description", true),
    OG_IMAGE("og:image", "image", true);

    private final String value;
    private final String key;
    private final boolean isOgTag;

    TagLinkPreviewType(String key, String value, boolean isOgTag) {
        this.key = key;
        this.value = value;
        this.isOgTag = isOgTag;
    }
}
