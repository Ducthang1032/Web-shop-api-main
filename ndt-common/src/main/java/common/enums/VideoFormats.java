package main.java.common.enums;

public enum VideoFormats {
    MP4("mp4"),
    MKV("mkv"),
    FLV("flv"),
    MOV("mov"),
    AVI("avi"),
    WMV("wmv");

    private final String type;

    VideoFormats(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
