package main.java.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum RoleAccount {
    ROOT(1L, "ROOT"),
    SUPER_ADMIN(2L, "SUPER_ADMIN"),
    ADMIN(3L, "ADMIN"),
    CONTENT_REVIEWER(4L, "CONTENT_REVIEWER"),
    USER(5L, "USER");

    private final Long roleId;
    private final String name;

    RoleAccount(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public static Long getRoleId(String role) {
        return Arrays.stream(RoleAccount.values())
                .filter(item -> item.getName().equalsIgnoreCase(role))
                .findFirst().map(RoleAccount::getRoleId).orElse(null);
    }

    public static List<RoleAccount> adminRole() {
        return Arrays.asList(ROOT, SUPER_ADMIN, ADMIN, CONTENT_REVIEWER);
    }

    public static List<Long> adminRoleId() {
        return adminRole().stream().map(RoleAccount::getRoleId).collect(Collectors.toList());
    }

    public static String getRoleName(Long roleId) {
        return Arrays.stream(RoleAccount.values())
                .filter(item -> item.getRoleId().equals(roleId))
                .findFirst().map(RoleAccount::getName).orElse(null);
    }
}