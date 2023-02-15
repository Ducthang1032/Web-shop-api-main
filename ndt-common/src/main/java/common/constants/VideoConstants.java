package main.java.common.constants;

public interface VideoConstants {
    String MP4_AUDIO_ENCODER = "aac";
    int MP4_AUDIO_BIT_RATE_DEFAULT = 64000;
    int MP4_AUDIO_SAMPLING_RATE_DEFAULT = 22050;
    int MP4_AUDIO_CHANNELS_DEFAULT = 2;
    String MP4_VIDEO_ENCODER = "libx264";
    int MP4_VIDEO_BIT_RATE_DEFAULT = 160000;
    int MP4_VIDEO_FRAME_RATE_DEFAULT = 24;
    float MP4_VIDEO_DURATION_TO_GET_FIRST_FRAME = 0.1f;
}
