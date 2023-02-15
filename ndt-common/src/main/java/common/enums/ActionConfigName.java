package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionConfigName {
    FRIEND_POST("friend_post"),
    FOLLOWING_POST("following_post"),
    FAMOUS_FOLLOWING_POST("famous_following_post"),
    FAVORITE_POST("favorite_post"),
    GROUP_POST("group_post"),
    GROUP_FRIEND_POST("group_friend_post"),
    GROUP_POPULAR_POST("group_popular_post"),
    POST_CONTAIN_TEXT("post_contain_text"),
    POST_CONTAIN_PHOTO("post_contain_photo"),
    POST_CONTAIN_VIDEO("post_contain_video"),
    POST_CONTAIN_URL("post_contain_url"),
    POST_CONTAIN_LIVESTREAM("post_contain_livestream"),
    LESS_THEN_10_LIKE("less_than_10_like"),
    LIKE_10_TO_50("10_to_50_like"),
    LIKE_51_TO_100("51_to_100_like"),
    MORE_THAN_100_LIKE("more_than_100_like"),
    LESS_THAN_10_SHARE("less_than_10_share"),
    SHARE_10_TO_50("10_to_50_share"),
    SHARE_51_TO_100("51_to_100_share"),
    MORE_THAN_100_SHARES("more_than_100_shares"),
    USER_POST("user_post"),
    MEMBERS_500_TO_999("500_to_999_members"),
    MEMBERS_1000_TO_9999("1000_to_9999_members"),
    MEMBERS_10000_TO_99999("10000_to_99999_members"),
    MEMBERS_100000_TO_999999("100000_to_999999_members"),
    MORE_THAN_1M_MEMBERS("more_than_1M_members");

    private final String type;

    ActionConfigName(String type) {
        this.type = type;
    }
}
