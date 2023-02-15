package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum MemberStatusActions {
    APPROVE("approve", "active"),
    DECLINE("decline", "inactive"),
    BLOCK("block", "blocked"),
    MUTE("mute", "muted"),
    POST_APPROVAL("post_approval", "pre-approve"),
    UN_MUTE("unmute", "active"),
    UN_BLOCK("unblock", "inactive"),
    REMOVE("remove", "inactive"),
    JOIN_GROUP("join-group", "pending"),
    BE_INVITED("be-invited", "invited"),
    PRE_POST_APPROVAL("pre_post_approval", "pre_post_approval"),
    REMOVE_PRE_APPROVAL("remove_pre_approval", "remove_pre_approval");

    private final String code;
    private final String value;

    MemberStatusActions(String code, String value) {
        this.value = value;
        this.code = code;
    }

    public static MemberStatusActions fromCode(String code) {
        for (MemberStatusActions requestChange : MemberStatusActions.values()) {
            if (requestChange.getCode().equalsIgnoreCase(code))
                return requestChange;
        }
        return null;
    }

    public static boolean actionUpdateStatusMember(String code) {
        List<MemberStatusActions> actionsUpdateStatusMember = Arrays.asList(BLOCK, UN_BLOCK, MUTE, UN_MUTE, PRE_POST_APPROVAL, REMOVE_PRE_APPROVAL);
        return actionsUpdateStatusMember.stream().anyMatch(item -> item.getCode().equalsIgnoreCase(code));
    }
}
