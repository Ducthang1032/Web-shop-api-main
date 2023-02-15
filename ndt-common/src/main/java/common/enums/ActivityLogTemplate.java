package main.java.common.enums;

import lombok.Getter;

import static com.tdt.cqsta.common.constants.CommonConstant.*;

@Getter
public enum ActivityLogTemplate {
    //Content Management
    CONTENT_MANAGER_HAS_HIDDEN_THE_POST("C1", String.format("%s hidden %s's post", ACTOR_NAME, POST_OWNER)),
    CONTENT_MANAGER_HAS_KEPT_THE_POST("C2", String.format("%s kept %s's post", ACTOR_NAME, POST_OWNER)),
    CONTENT_MANAGER_MADE_THE_POST_AVAILABLE("C3", String.format("%s made %s's post available", ACTOR_NAME, POST_OWNER)),
    CONTENT_MANAGER_DELETED_THE_POST("C4", String.format("%s deleted %s's post", ACTOR_NAME, POST_OWNER)),

    //User Management
    USER_MANAGER_HAS_UPDATED_THE_ROLE("U1", String.format("%s updated role for account %s", ACTOR_NAME, USER_NAME)),
    USER_MANAGER_HAS_UPDATED_PERMISSION_FOR_A_ROLE("U2", String.format("%s updated role definition for %s", ACTOR_NAME, ROLE_NAME)),
    USER_MANAGER_HAS_CREATE_AN_ACCOUNT("U3", String.format("%s created a new account %s", ACTOR_NAME, USER_NAME)),
    USER_MANAGER_HAS_BLOCK_ACCOUNT("U4", String.format("%s blocked account %s", ACTOR_NAME, USER_NAME)),
    USER_MANAGER_HAS_UN_BLOCK_ACCOUNT("U5", String.format("%s unblocked account %s", ACTOR_NAME, USER_NAME)),
    USER_MANAGER_HAS_REMOVE_ACCOUNT("U6", String.format("%s removed account %s", ACTOR_NAME, USER_NAME)),

    //Group Management
    GROUP_MANAGER_HAS_WARN_GROUP("G1", String.format("%s warned group %s", ACTOR_NAME, GROUP_NAME)),
    GROUP_MANAGER_HAS_BLOCK_GROUP("G2", String.format("%s blocked group %s", ACTOR_NAME, GROUP_NAME)),
    GROUP_MANAGER_HAS_UN_WARN_GROUP("G3", String.format("%s unwarned group %s", ACTOR_NAME, GROUP_NAME)),
    GROUP_MANAGER_HAS_UN_BLOCK_GROUP("G4", String.format("%s unblocked group %s", ACTOR_NAME, GROUP_NAME)),
    GROUP_MANAGER_HAS_REMOVE_GROUP("G5", String.format("%s remove group %s", ACTOR_NAME, GROUP_NAME)),

    //Notification Management
    NOTIFICATION_MANAGER_HAS_CREATE_NOTIFICATION("N1", String.format("%s created a system notification", ACTOR_NAME)),
    NOTIFICATION_MANAGER_HAS_EDIT_NOTIFICATION("N2", String.format("%s edited a system notification", ACTOR_NAME)),
    NOTIFICATION_MANAGER_HAS_DELETE_NOTIFICATION("N3", String.format("%s deleted a system notification", ACTOR_NAME)),

    //Setting Management
    SETTING_MANAGER_HAS_UPDATE_SETTING("S1", String.format("%s updated system setting", ACTOR_NAME)),

    // Cqtv Management
    CQTV_MANAGER_UPLOAD_VIDEO("V1", String.format("%s updated a new video", ACTOR_NAME)),
    CQTV_MANAGER_DELETE_VIDEO("V2", String.format("%s deleted a video", ACTOR_NAME)),
    CQTV_MANAGER_EDIT_VIDEO("V3", String.format("%s edited a video", ACTOR_NAME));

    private final String activityType;
    private final String activityTem;

    ActivityLogTemplate(String activityType, String activityTem) {
        this.activityType = activityType;
        this.activityTem = activityTem;
    }
}
