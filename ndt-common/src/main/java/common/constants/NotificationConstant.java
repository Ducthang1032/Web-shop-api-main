package main.java.common.constants;

import com.tdt.cqsta.common.enums.NotificationTemplate;

import java.util.ArrayList;
import java.util.List;

public interface NotificationConstant {
    List<String> COMMENT_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_POST_THAT_YOU_COMMENTED.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_POST_THAT_YOU_COMMENTED.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_COMMENT_THAT_YOURE_MENTIONED_IN_OTHERS_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIED_TO_A_COMMENT_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIED_TO_A_COMMENT_ON_TIMELINE.getNotiType());
        }
    };

    List<String> TAG_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_TAGS_YOU_IN_A_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_MENTIONS_YOU_IN_A_COMMENT.getNotiType());
            add(NotificationTemplate.SOMEONE_POSTS_ON_YOUR_TIMELINE.getNotiType());
        }
    };

    List<String> GROUP_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.PENDING_POST_TO_BE_APPROVED.getNotiType());
            add(NotificationTemplate.SOME_PENDING_POST_TO_BE_APPROVED.getNotiType());
            add(NotificationTemplate.POST_IN_GROUP_HAS_BEEN_APPROVED.getNotiType());
            add(NotificationTemplate.SOMEONE_REPORTS_A_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_CONTENTS_REPORTED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REQUEST_TO_JOIN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REQUEST_TO_JOIN_GROUP.getNotiType());
            add(NotificationTemplate.WELCOME_MEMBER_AFTER_TO_BE_APPROVED_JOINING_GROUP.getNotiType());
            add(NotificationTemplate.ADMINS_REJECT_USER_FROM_JOINING_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REQUIRED_APPROVAL_TO_JOIN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REQUIRED_APPROVAL_TO_JOIN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_INVITED_YOU_TO_JOIN_GROUP.getNotiType());
            add(NotificationTemplate.ADMIN_OR_YOUR_FRIEND_POSTS_IN_GROUP.getNotiType());
            add(NotificationTemplate.ADMIN_CHANGES_GROUP_RULES.getNotiType());
            add(NotificationTemplate.ADMIN_CHANGES_GROUP_PRIVACY.getNotiType());
            add(NotificationTemplate.ADMIN_CHANGES_GROUP_NAME.getNotiType());
            add(NotificationTemplate.ADMIN_CHANGES_GROUP_COVER_PHOTO.getNotiType());
            add(NotificationTemplate.YOU_HAVE_BEEN_ADDED_ADMIN.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST_ON_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST_ON_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_ON_A_POST_THAT_YOU_COMMENTED_IN_A_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_ON_A_POST_THAT_YOU_COMMENTED_IN_A_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_TAGS_YOU_IN_A_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_MENTIONS_YOU_IN_A_COMMENT_IN_A_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REPORT_A_POST_IN_GROUP.getNotiType());
        }
    };

    List<String> FRIEND_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_SENDS_YOU_A_FRIEND_REQUEST.getNotiType());
            add(NotificationTemplate.SOMEONE_ACCEPTS_YOUR_FRIEND_REQUEST.getNotiType());
        }
    };
    List<String> FAVOURITE_PEOPLE_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.YOUR_FAVOURITE_PEOPLE_CREATES_A_POST.getNotiType());
        }
    };

    List<String> POST_NOTI_FLG = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST_ON_TIMELINE.getNotiType());
        }
    };
}
