package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.tdt.cqsta.common.constants.CommonConstant.*;

@Getter
public enum NotificationTemplate {
    //Post notifications
    SOMEONE_LIKES_YOUR_POST("P1", String.format("%s liked your post", ACTOR_NAME)),
    SOME_PEOPLE_LIKE_YOUR_POST("P2", String.format("%s and others liked your post", ACTOR_NAME)),
    SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN("P3", String.format("%s liked a post that you are tagged in", ACTOR_NAME)),
    SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN("P4", String.format("%s and others liked a post that you are tagged in", ACTOR_NAME)),
    SOMEONE_LIKES_YOUR_POST_ON_TIMELINE("P5", String.format("%s liked a post on your timeline", ACTOR_NAME)),
    SOME_PEOPLE_LIKE_YOUR_POST_ON_TIMELINE("P6", String.format("%s and others liked a post on your timeline", ACTOR_NAME)),
    SOMEONE_COMMENTED_ON_YOUR_POST("P7", String.format("%s commented on your post", ACTOR_NAME)),
    YOUR_FRIEND_COMMENTS_POST_THAT_YOURE_TAGGED_IN("P8", String.format("%s commented on a post that you are tagged in", ACTOR_NAME)),
    YOUR_FRIEND_COMMENTS_POST_THAT_YOU_COMMENTED("P9", String.format("%s commented on %s's post", ACTOR_NAME, POST_OWNER)),
    SOMEONE_REPLIES_COMMENT_THAT_YOURE_MENTIONED_IN_OTHERS_POST("P10", String.format("%s replied to a comment that you're mentioned on %s's post", ACTOR_NAME, POST_OWNER)),

    SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST("P11", String.format("%s replied to your comment on %s's post", ACTOR_NAME, POST_OWNER)),
    SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST("P12", String.format("%s replied to a comment on your post", ACTOR_NAME)),
    SOMEONE_TAGS_YOU_IN_A_POST("P13", String.format("%s tagged you in a post", ACTOR_NAME)),
    SOMEONE_MENTIONS_YOU_IN_A_COMMENT("P14", String.format("%s mentions you in a comment", ACTOR_NAME)),
    SOMEONE_POSTS_ON_YOUR_TIMELINE("P15", String.format("%s posts on your timeline", ACTOR_NAME)),
    YOUR_FAVOURITE_PEOPLE_CREATES_A_POST("P16", String.format("%s posted an update", ACTOR_NAME)),
    SOMEONE_SHARES_YOUR_POST("P17", String.format("%s shared your post", ACTOR_NAME)),
    SOMEONE_SHARES_POST_ON_YOUR_TIMELINE("P18", String.format("%s shared a post on your timeline", ACTOR_NAME)),
    SOMEONE_COMMENTED_ON_YOUR_POST_ON_TIMELINE("P19", String.format("%s commented on a post on your timeline", ACTOR_NAME)),
    SOMEONE_REPLIED_TO_A_COMMENT_ON_TIMELINE("P20", String.format("%s replied to a comment on a post on your timeline", ACTOR_NAME)),

    SOMEONE_ONE_LIKE_YOUR_COMMENT("P21", String.format("%s liked your comment", ACTOR_NAME)),
    SOMEONE_ONE_AND_OTHER_LIKE_YOUR_COMMENT("P22", String.format("%s and others liked your comment", ACTOR_NAME)),
    PEOPLE_COMMENTED_ON_YOUR_POST("P23", String.format("%s and others commented on your post", ACTOR_NAME)),
    YOUR_FRIENDS_COMMENTS_POST_THAT_YOURE_TAGGED_IN("P24", String.format("%s and others commented on a post that you are tagged in", ACTOR_NAME)),
    YOUR_FRIENDS_COMMENTS_POST_THAT_YOU_COMMENTED("P25", String.format("%s and others commented on %s's post", ACTOR_NAME, POST_OWNER)),
    PEOPLE_REPLIES_COMMENT_THAT_YOURE_MENTIONED_IN_OTHERS_POST("P26", String.format("%s and others replied to a comment that you're mentioned on %s's post", ACTOR_NAME, POST_OWNER)),
    SOME_PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST("P27", String.format("%s and others replied to your comment on %s's post", ACTOR_NAME, POST_OWNER)),
    PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST("P28", String.format("%s and others replied to a comment on your post", ACTOR_NAME)),
    PEOPLE_COMMENTED_ON_YOUR_POST_ON_TIMELINE("P29", String.format("%s and others commented on a post on your timeline", ACTOR_NAME)),
    PEOPLE_REPLIED_TO_A_COMMENT_ON_TIMELINE("P30", String.format("%s and others replied to a comment on a post on your timeline", ACTOR_NAME)),

    //Friend Request notifications
    SOMEONE_SENDS_YOU_A_FRIEND_REQUEST("FR1", String.format("%s sent you a friend request", ACTOR_NAME)),
    SOMEONE_ACCEPTS_YOUR_FRIEND_REQUEST("FR2", String.format("%s accepted your friend request", ACTOR_NAME)),

    //Group notifications
    PENDING_POST_TO_BE_APPROVED("G1", String.format("%s's post in %s needs approval", ACTOR_NAME, GROUP_NAME)),
    SOME_PENDING_POST_TO_BE_APPROVED("G2", String.format("Some pending posts in %s needs approval", GROUP_NAME)),
    POST_IN_GROUP_HAS_BEEN_APPROVED("G3", String.format("An admin approved your post in %s", GROUP_NAME)),
    SOMEONE_REPORTS_A_POST_IN_GROUP("G4", String.format("%s reported a post in %s", ACTOR_NAME, GROUP_NAME)),
    SOME_CONTENTS_REPORTED_IN_GROUP("G5", String.format("Some contents reported in %s needs to be reviewed", GROUP_NAME)),
    SOMEONE_REQUEST_TO_JOIN_GROUP("G6", String.format("%s requested to join your group: %s", ACTOR_NAME, GROUP_NAME)),
    SOME_PEOPLE_REQUEST_TO_JOIN_GROUP("G7", String.format("%s and others requested to join your group: %s", ACTOR_NAME, GROUP_NAME)),
    WELCOME_MEMBER_AFTER_TO_BE_APPROVED_JOINING_GROUP("G8", String.format("Welcome to %s. Admins have approved your request to join", GROUP_NAME), String.format("Admins have approved your request to join %s", GROUP_NAME)),
    SOMEONE_REQUIRED_APPROVAL_TO_JOIN_GROUP("G9", String.format("%s required approval to join %s", ACTOR_NAME, GROUP_NAME)),
    SOME_PEOPLE_REQUIRED_APPROVAL_TO_JOIN_GROUP("G10", String.format("%s and others required approval to join %s", ACTOR_NAME, GROUP_NAME)),

    SOMEONE_INVITED_YOU_TO_JOIN_GROUP("G11", String.format("%s invited you to join %s", ACTOR_NAME, GROUP_NAME)),
    ADMIN_OR_YOUR_FRIEND_POSTS_IN_GROUP("G12", String.format("%s posted in %s", ACTOR_NAME, GROUP_NAME)),
    ADMIN_CHANGES_GROUP_RULES("G13", String.format("Admin changed %s's group rules", GROUP_NAME)),
    ADMIN_CHANGES_GROUP_PRIVACY("G14", String.format("Admin changed %s's group privacy", GROUP_NAME)),
    ADMIN_CHANGES_GROUP_NAME("G15", String.format("An admin changed the name of the group %s to %s", OLD_GROUP_NAME, NEW_GROUP_NAME), String.format("Admin changed the name of the group %s to %s", OLD_GROUP_NAME, NEW_GROUP_NAME)),
    ADMIN_CHANGES_GROUP_COVER_PHOTO("G16", String.format("Admin changed %s's cover photo", GROUP_NAME)),
    YOU_HAVE_BEEN_ADDED_ADMIN("G17", String.format("You have been added as group admin of %s", GROUP_NAME)),
    SOMEONE_LIKES_YOUR_POST_IN_GROUP("G18", String.format("%s liked your post in %s", ACTOR_NAME, GROUP_NAME)),
    SOME_PEOPLE_LIKE_YOUR_POST_IN_GROUP("G19", String.format("%s and others liked your post in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN_GROUP("G20", String.format("%s liked a post that you are tagged in %s", ACTOR_NAME, GROUP_NAME)),

    SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN_GROUP("G21", String.format("%s and others liked a post that you are tagged in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_COMMENTED_ON_YOUR_POST_ON_GROUP("G22", String.format("%s commented on your post in %s", ACTOR_NAME, GROUP_NAME)),
    YOUR_FRIEND_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP("G23", String.format("%s commented on a post that you are tagged in %s", ACTOR_NAME, GROUP_NAME)),
    YOUR_FRIEND_COMMENTS_ON_A_POST_THAT_YOU_COMMENTED_IN_A_GROUP("G24", String.format("%s commented on a post that you are following in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP("G25", String.format("%s replied to a comment that you're mentioned in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP("G26", String.format("%s replied to your comment in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP("G27", String.format("%s replied to a comment on your post in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_TAGS_YOU_IN_A_POST_IN_GROUP("G28", String.format("%s tagged you in a post in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_MENTIONS_YOU_IN_A_COMMENT_IN_A_GROUP("G29", String.format("%s mentioned you in a comment in %s", ACTOR_NAME, GROUP_NAME)),
    PEOPLE_COMMENTED_ON_YOUR_POST_ON_GROUP("G30", String.format("%s and others commented on your post in %s", ACTOR_NAME, GROUP_NAME)),

    YOUR_FRIENDS_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP("G31", String.format("%s commented on a post that you are tagged in %s", ACTOR_NAME, GROUP_NAME)),
    YOUR_FRIENDS_COMMENTS_ON_A_POST_THAT_YOU_COMMENTED_IN_A_GROUP("G32", String.format("%s and others commented on a post that you are following in %s", ACTOR_NAME, GROUP_NAME)),
    PEOPLE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP("G33", String.format("%s and others replied to a comment that you're mentioned in %s", ACTOR_NAME, GROUP_NAME)),
    PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP("G34", String.format("%s and others replied to your comment in %s", ACTOR_NAME, GROUP_NAME)),
    PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP("G35", String.format("%s and others replied to a comment on your post in %s", ACTOR_NAME, GROUP_NAME)),
    ADMINS_REJECT_USER_FROM_JOINING_GROUP("G36", String.format("Your request to join %s has been rejected by group admin", GROUP_NAME), String.format("Admins have decline your request to join %s", GROUP_NAME)),
    SOME_PEOPLE_REPORT_A_POST_IN_GROUP("G37", String.format("%s and others report a post in %s", ACTOR_NAME, GROUP_NAME)),

    //Admin
    ADMIN_SEND_FOR_ALL_USER("SN1", "Admin send notification for all user"),
    CQ_ADMINS_WARNS_GROUP_FOR_VIOLATING_ONE_TIME("SN2", String.format("Your group %s has been warned for violating CQ Station’s policy of %s.", GROUP_NAME, REASON_NAME)),
    CQ_ADMINS_WARNS_GROUP_FOR_VIOLATING_MANNY_TIME("SN3", String.format("Your group %s has been warned for violating CQ Station’s policy of %s and other reasons.", GROUP_NAME, REASON_NAME)),
    CQ_ADMINS_DELETE_POST("SN4", String.format("Your post has been deleted for violating CQ Station’s policy of %s and other reasons.", REASON_NAME), "Admin deleted your post"),
    CQ_ADMINS_DELETE_POST_IN_GROUP("SN5", String.format("Your post in %s has been deleted for violating CQ Station’s policy of %s and other reasons.", GROUP_NAME, REASON_NAME), String.format("Admin deleted your post in %s", GROUP_NAME)),
    CQ_ADMINS_HIDE_POST("SN6", String.format("Your post has been hided for violating CQ Station’s policy of %s and other reasons.", REASON_NAME), "Admin hide your post"),
    CQ_ADMINS_HIDE_POST_IN_GROUP("SN7", String.format("Your post in %s has been hided for violating CQ Station’s policy of %s and other reasons.", GROUP_NAME, REASON_NAME), String.format("Admin hide your post in %s", GROUP_NAME)),
    SOMEONE_REPORTED_A_POST_ONE_REPORTER("SN8", String.format("%s reported a post.", ACTOR_NAME)),
    SOMEONE_REPORTED_A_POST_MANY_REPORTER("SN9", String.format("%s and others reported a post ", ACTOR_NAME)),
    SOMEONE_REPORTED_A_POST_IN_GROUP_ONE_REPORTER("SN10", String.format("%s reported a post in %s", ACTOR_NAME, GROUP_NAME)),
    SOMEONE_REPORTED_A_POST_IN_GROUP_MANY_REPORTER("SN11", String.format("Some contents reported in %s needs to be reviewed", GROUP_NAME)),

    //Chat
    SEND_MESSAGE_TO_DIRECT("D1", String.format("%s", MESSAGE_CONTENT)),
    REACT_A_MESSAGE("D2", String.format("%s reacted %s your message", ACTOR_NAME, REACT_EMOJI_NAME)),
    SEND_AN_IMAGE("D3", String.format("%s sent an image", ACTOR_NAME)),
    SEND_A_VIDEO("D4", String.format("%s sent a video", ACTOR_NAME)),
    SEND_AN_ATTACHMENT("D5", String.format("%s sent an attachment", ACTOR_NAME)),
    SEND_MESSAGE_TO_STRANGER("D6", String.format("%s wants to send you a message", ACTOR_NAME)),
    REMOVE_MESSAGE("D7", String.format("%s removed a message", ACTOR_NAME)),
    PIN_MESSAGE("D8", String.format("%s pined a message", ACTOR_NAME)),
    UNPIN_MESSAGE("D9", String.format("%s unpined a message", ACTOR_NAME)),
    ADD_MEMBER_TO_CHANNEL("C1", String.format("%s added you to channel", ACTOR_NAME)),
    REMOVE_MEMBER_TO_CHANNEL("C2", String.format("%s removed you from channel", ACTOR_NAME)),
    MAKE_USER_CHANNEL_ADMIN("C3", String.format("%s make you as a channel admin", ACTOR_NAME)),
    REMOVE_USER_CHANNEL_ADMIN("C4", String.format("%s removed you as a channel admin", ACTOR_NAME)),
    CHANGE_CHANNEL_DISPLAY_NAME("C5", String.format("%s named the channel %s", ACTOR_NAME, CHANEL_DISPLAY_NAME)),
    CHANGE_CHANNEL_DESCRIPTION("C6", String.format("%s change channel %s's description", ACTOR_NAME, CHANEL_DISPLAY_NAME)),
    SEND_MESSAGE_TO_CHANEL("C8", String.format("%s: %s", ACTOR_NAME, MESSAGE_CONTENT)),
    ADD_MEMBER_TO_GROUP("T1", String.format("%s added you to group", ACTOR_NAME)),
    REMOVE_MEMBER_TO_GROUP("T2", String.format("%s removed you from group", ACTOR_NAME)),
    CHANGE_GROUP_DISPLAY_NAME("T3", String.format("%s named the group %s", ACTOR_NAME, GROUP_DISPLAY_NAME)),
    CHANGE_GROUP_DESCRIPTION("T4", String.format("%s change group %s's description", ACTOR_NAME, GROUP_DISPLAY_NAME)),
    MAKE_USER_GROUP_ADMIN("T5", String.format("%s make you as a group admin", ACTOR_NAME)),
    REMOVE_USER_GROUP_ADMIN("T6", String.format("%s removed you as a group admin", ACTOR_NAME));

    private final String notiType;
    private final String notiTem;
    private final String notiTemPoem;

    NotificationTemplate(String notiType, String notiTem) {
        this.notiType = notiType;
        this.notiTem = notiTem;
        this.notiTemPoem = notiTem;
    }

    NotificationTemplate(String notiType, String notiTem, String notiTemPoem) {
        this.notiTem = notiTem;
        this.notiType = notiType;
        this.notiTemPoem = notiTemPoem;
    }

    public static String getNotificationTemplate(String notiType, Long subSystem) {
        boolean isPoem = SubSystem.isPoem(subSystem);
        return Arrays.stream(NotificationTemplate.values())
                .filter(noti -> noti.getNotiType().equals(notiType)).findFirst()
                .map(item -> isPoem ? item.notiTemPoem : item.notiTem).orElse(StringUtils.EMPTY);
    }

    public static NotificationTemplate getNotiTemplate(String notiType) {
        return Arrays.stream(NotificationTemplate.values())
                .filter(item -> StringUtils.equals(notiType, item.getNotiType())).findFirst().orElse(null);
    }

}