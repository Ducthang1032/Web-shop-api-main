package main.java.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum GroupRole {
    ADMIN("admin"),
    MEMBER("member");

    private String value;

    GroupRole(String value) {
        this.value = value;
    }

    public static boolean isAdmin(String role) {
        return GroupRole.ADMIN.getValue().equalsIgnoreCase(role);
    }
}
