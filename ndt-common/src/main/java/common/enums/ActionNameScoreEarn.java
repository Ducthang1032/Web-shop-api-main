package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionNameScoreEarn {
    DAILY_LOGIN("daily_log_in"),
    SHARE_INTERNALLY ("share_internally"),
    SHARE_EXTERNALLY("share_externally"),
    LIKE_ARTICLE_OR_POSTING("like_article_or_posting"),
    VIEW_VIDEO_ABOVE_ONE_MIN("view_video_above_one_min"),
    POST_ARTICLE_OR_CONTENT("post_article_or_content"),
    COMMENT_ON_ARTICLE_OR_POST("comment_on_article_or_post"),
    ATTEND_E_LEARNING_COURSE("attend_e_learning_course"),
    ONLINE_MORE_THAN_TEN_MIN("online_more_than_ten_min");

    private String action;

    ActionNameScoreEarn(String action) {
        this.action = action;
    }
}
