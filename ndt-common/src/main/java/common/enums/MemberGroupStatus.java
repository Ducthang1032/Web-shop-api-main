package main.java.common.enums;

import lombok.Getter;

@Getter
public enum MemberGroupStatus {
    PENDING("pending"),
    ACTIVE("active"),
    MUTED("muted"),
    ACTIVE_MUTED("active_muted"),
    BLOCKED("blocked"),
    INVITED("invited"),
    INACTIVE("inactive"),
    PENDING_INVITATION("pending_invitation"),
    NO_STATUS("no_status");

    private final String value;

    MemberGroupStatus(String value) {
        this.value = value;
    }

    public static boolean isBlocked(String status) {
        return MemberGroupStatus.BLOCKED.getValue().equalsIgnoreCase(status);
    }

    public static boolean isInvited(String status) {
        return MemberGroupStatus.INVITED.getValue().equalsIgnoreCase(status);
    }

    public static boolean isActive(String status) {
        return MemberGroupStatus.ACTIVE.getValue().equalsIgnoreCase(status);
    }

    public static boolean isMuted(String status) {
        return MemberGroupStatus.MUTED.getValue().equalsIgnoreCase(status);
    }
}
