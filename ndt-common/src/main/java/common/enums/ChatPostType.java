package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ChatPostType {

    SYSTEM_JOIN_CHANNEL("system_join_channel", "%s joined the channel."),
    SYSTEM_CHANNEL_DELETED("system_channel_deleted", "%s has closed the channel."),
    SYSTEM_DISPLAY_NAME_CHANGE("system_displayname_change", "%s updated the channel display name from: %s to: %s"),
    SYSTEM_HEADER_CHANGE("system_header_change", "%s updated the channel header from: %s to: %s"),
    SYSTEM_HEADER_CHANGE_WITHOUT_OLD_HEADER("system_header_change", "%s updated the channel header to: %s"),
    SYSTEM_LEAVE_CHANNEL("system_leave_channel", "%s left the channel."),
    SYSTEM_PURPOSE_CHANGE("system_purpose_change", "%s updated the channel purpose from: %s to: %s"),
    SYSTEM_PURPOSE_CHANGE_WITHOUT_OLD_PURPOSE("system_purpose_change", "%s updated the channel purpose to: %s"),
    SYSTEM_REMOVE_FROM_CHANNEL("system_remove_from_channel", "%s removed %s from the channel."),
    SYSTEM_ADD_TO_CHANNEL("system_add_to_channel", "%s added %s to the channel.");

    private final String type;
    private final String message;

    ChatPostType(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public static boolean isSystemJoinChannel(String postType) {
        return SYSTEM_JOIN_CHANNEL.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemChannelDeleted(String postType) {
        return SYSTEM_CHANNEL_DELETED.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemDisplayNameChange(String postType) {
        return SYSTEM_DISPLAY_NAME_CHANGE.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemHeaderChange(String postType) {
        return SYSTEM_HEADER_CHANGE.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemLeaveChannel(String postType) {
        return SYSTEM_LEAVE_CHANNEL.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemPurposeChange(String postType) {
        return SYSTEM_PURPOSE_CHANGE.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemRemoveFromChannel(String postType) {
        return SYSTEM_REMOVE_FROM_CHANNEL.getType().equalsIgnoreCase(postType);
    }

    public static boolean isSystemAddToChannel(String postType) {
        return SYSTEM_ADD_TO_CHANNEL.getType().equalsIgnoreCase(postType);
    }
}
