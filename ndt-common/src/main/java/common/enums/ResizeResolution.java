package main.java.common.enums;

public enum ResizeResolution {
    R240P(426, 240),
    R360P(480, 360),
    R480P(640, 480),
    R720P(1280, 720),
    R1080P(1920, 1080),
    R1440P(2560, 1440),
    IMAGE_DEFAULT(480, 360),
    VIDEO_DEFAULT(400, 300),
    THUMBNAIL(189, 100),
    SMALL_THUMBNAIL(100, 100);

    private final int width;
    private final int height;

    ResizeResolution(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
