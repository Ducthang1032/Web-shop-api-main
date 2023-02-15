package main.java.common.enums;

import lombok.Getter;

@Getter
public enum ActionPointHistory {

    REDEEM_VOUCHER("Redeem Voucher"),
    DAILY_LOGIN("Daily login"),
    SHARE_POST_IN_APP("Share post in app"),
    SHARE_POST_OUT_APP("Share post out app"),
    LIKE_POST("Like post"),
    VIEW_VIDEO("View video"),
    CREATE_POST("Create post"),
    COMMENT("Comment"),
    ATTEND_LEARNING("Attend learning"),
    STAY_ONLINE("Stay online"),
    REFUND_POINT("Refund point");

    private final String action;

    ActionPointHistory(String action) {
        this.action = action;
    }
}
