package main.java.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum ApproveMemberType {
    ADMIN("admin"),
    EVERYONE("everyone");

    private final String type;

    ApproveMemberType(String type) {
        this.type = type;
    }

    public static boolean isApproveMemRequest(String approveMemRequest) {
        return Arrays.stream(ApproveMemberType.values()).anyMatch(item -> item.getType().equalsIgnoreCase(approveMemRequest));
    }

    public static String formatType(String value) {
        ApproveMemberType approveMemberType = Arrays.stream(ApproveMemberType.values())
                .filter(item -> item.getType().equalsIgnoreCase(value)).findFirst().orElse(null);
        return Objects.nonNull(approveMemberType) ? approveMemberType.getType() : StringUtils.EMPTY;
    }
}
