package main.java.common.constants;

import com.tdt.cqsta.common.enums.NotificationTemplate;

import java.util.ArrayList;
import java.util.List;

public interface NotificationPoem3Constants {

    List<String> NOTI_TYPE_POST_LIST = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_POST_THAT_YOURE_TAGGED_IN.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_POST_THAT_YOU_COMMENTED.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_POST_THAT_YOU_COMMENTED.getNotiType());
            add(NotificationTemplate.SOMEONE_SHARES_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_SHARES_POST_ON_YOUR_TIMELINE.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_LIKES_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_LIKE_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST_ON_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST_ON_GROUP.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REPORT_A_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIEND_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.YOUR_FRIENDS_COMMENTS_ON_A_POST_THAT_YOURE_TAGGED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_COMMENTED_ON_YOUR_POST_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.PEOPLE_COMMENTED_ON_YOUR_POST_ON_TIMELINE.getNotiType());
        }
    };

    List<String> NOTI_TYPE_TAG_PEOPLE_LIST = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_TAGS_YOU_IN_A_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_TAGS_YOU_IN_A_POST_IN_GROUP.getNotiType());
        }
    };

    List<String> NOTI_TYPE_COMMENT_LIST = new ArrayList<String>() {
        {
            add(NotificationTemplate.SOMEONE_REPLIES_COMMENT_THAT_YOURE_MENTIONED_IN_OTHERS_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST.getNotiType());
            add(NotificationTemplate.SOME_PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIED_TO_A_COMMENT_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIED_TO_A_COMMENT_ON_TIMELINE.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_A_COMMENT_THAT_YOURE_MENTIONED_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_YOUR_COMMENT_ON_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.SOMEONE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP.getNotiType());
            add(NotificationTemplate.PEOPLE_REPLIES_TO_COMMENT_ON_YOUR_POST_IN_GROUP.getNotiType());
        }
    };

}
