package main.java.common.utils;

import com.tdt.cqsta.common.constants.CommonConstant;
import com.tdt.cqsta.common.constants.OTPConstant;
import com.tdt.cqsta.common.enums.GroupPrivacy;
import com.tdt.cqsta.common.enums.NotificationTemplate;

public class RedisKeyUtil {
    public static String redisConfirmPasswordKey(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.REDIS_CONFIRM_PASSWORD_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }

    public static String redisConfirmMailOrPhoneKey(String prefixRedisKey, String emailOrPhone, Long subSystem) {
        return redisConfirmMailOrPhoneKey(prefixRedisKey, emailOrPhone, String.valueOf(subSystem));
    }

    public static String redisConfirmMailOrPhoneKey(String prefixRedisKey, String emailOrPhone, String subSystem) {
        return prefixRedisKey.concat(OTPConstant.REDIS_CONFIRM_MAIL_OR_PHONE_KEY).concat(subSystem)
                .concat(CommonConstant.COLON).concat(emailOrPhone);
    }

    public static String getMemberRightKey(String uriRights, String method, String groupPrivacy, String groupVisible) {
        StringBuilder memberRightKey = new StringBuilder(uriRights).append(method)
                .append(groupPrivacy.toLowerCase());
        if (GroupPrivacy.PRIVATE.getValue().equalsIgnoreCase(groupPrivacy))
            memberRightKey.append(CommonConstant.UNDERSCORE).append(groupVisible.toLowerCase());
        return memberRightKey.toString();
    }

    public static String getUserExistKey(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.CQ_USER_EXIST_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }

    public static String getUserSettingKey(String prefixRedisKey, Long userId) {
        return prefixRedisKey.concat(CommonConstant.CQ_USER_SETTING_KEY).concat(String.valueOf(userId));
    }

    public static String getFcmTokenKey(String prefixRedisKey, Long userId, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.FCM_TOKEN_KEY).concat(String.valueOf(userId))
                .concat(CommonConstant.COLON).concat(deviceId);
    }

    public static String getPoem3TokenKey(String prefixRedisKey, String userId, String p3Token) {
        return prefixRedisKey.concat(CommonConstant.POEM3_TOKEN_KEY).concat(userId).concat(p3Token);
    }

    public static String getPoem3TokenPushNotiKey(String prefixRedisKey, Long userId, Long subSystem, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.POEM3_TOKEN_PUSH_NOTI_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId))
                .concat(CommonConstant.COLON).concat(deviceId);
    }

    public static String getAccessTokenKey(String prefixRedisKey, Long userId, Long subSystem, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.ACCESS_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId)).concat(CommonConstant.COLON).concat(deviceId);
    }

    public static String getAccessTokenKeyListByUserId(String prefixRedisKey, String userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.ACCESS_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(userId).concat(CommonConstant.ASTERISK);
    }

    public static String getOtpKey(String prefixRedisKey, String subSystem, String emailOrPhone) {
        return prefixRedisKey.concat(OTPConstant.REDIS_OTP_KEY).concat(subSystem)
                .concat(CommonConstant.COLON).concat(emailOrPhone);
    }

    public static String getRefreshTokenKey(String prefixRedisKey, Long userId, Long subSystem, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.REFRESH_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId)).concat(CommonConstant.COLON).concat(deviceId);
    }

    public static String getRefreshTokenKeyListByUserId(String prefixRedisKey, String userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.REFRESH_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(userId).concat(CommonConstant.ASTERISK);
    }

    public static String getSPhotonChatTokenKey(String prefixRedisKey, Long userId, Long subSystem, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.SPHOTON_CHAT_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId)).concat(CommonConstant.COLON).concat(deviceId);
    }

    public static String getSPhotonChatIdKey(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.SPHOTON_CHAT_ID).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }

    public static String getSPhotonChatTokenKeyListByUserId(String prefixRedisKey, String userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.SPHOTON_CHAT_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(userId).concat(CommonConstant.ASTERISK);
    }

    public static String getTimesPasswordFailKey(String prefixRedisKey, String userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.CQ_CHECK_PASSWORD_FAIL).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(userId);
    }

    public static String getSpammingRequestKey(String prefixRedisKey, String redisKey, String uri, String method) {
        return prefixRedisKey.concat(CommonConstant.CQ_SPAM_REQUEST).concat(redisKey)
                .concat(CommonConstant.COLON).concat(uri).concat(CommonConstant.COLON).concat(method);
    }

    public static String getChatNotiKey(String prefixRedisKey, Long userId, NotificationTemplate notificationTemplate,
                                        String teamId, String channelId, String postId) {
        return prefixRedisKey.concat(CommonConstant.CQ_TIMEOUT_CHAT_NOTI).concat(String.valueOf(userId))
                .concat(CommonConstant.COLON).concat(notificationTemplate.getNotiType())
                .concat(CommonConstant.COLON).concat(teamId)
                .concat(CommonConstant.COLON).concat(channelId)
                .concat(CommonConstant.COLON).concat(postId);
    }

    public static String getCheckSpamNotificationKey(String prefixRedisKey, Long userId, Long userIdReceive,
                                                     String notiTemp, String objectId) {
        return prefixRedisKey.concat(CommonConstant.CQ_CHECK_SPAM_NOTIFICATION).concat(String.valueOf(userId))
                .concat(CommonConstant.COLON).concat(String.valueOf(userIdReceive))
                .concat(CommonConstant.COLON).concat(notiTemp)
                .concat(CommonConstant.COLON).concat(objectId);
    }

    public static String getLastViewAtOfUserKey(String prefixRedisKey, String userId, String subSystem) {
        return prefixRedisKey.concat(CommonConstant.USER_LAST_VIEW_AT_KEY).concat(subSystem)
                .concat(CommonConstant.COLON).concat(userId);
    }

    public static String getLastViewAtOfUserKey(String prefixRedisKey, Long userId, Long subSystem) {
        return getLastViewAtOfUserKey(prefixRedisKey, String.valueOf(userId), String.valueOf(subSystem));
    }

    public static String getLastActiveAtOfUserKey(String prefixRedisKey, String userId, String subSystem) {
        return prefixRedisKey.concat(CommonConstant.USER_LAST_ACTIVE_AT_KEY).concat(subSystem)
                .concat(CommonConstant.COLON).concat(userId);
    }

    public static String getLastActiveAtOfUserKey(String prefixRedisKey, Long userId, Long subSystem) {
        return getLastActiveAtOfUserKey(prefixRedisKey, String.valueOf(userId), String.valueOf(subSystem));
    }

    public static String redisConfirmQRCodeKey(String prefixRedisKey, Long subSystem, String fcmToken, String deviceId) {
        return prefixRedisKey.concat(CommonConstant.REDIS_CONFIRM_QR_CODE_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(deviceId).concat(CommonConstant.COLON).concat(fcmToken);
    }

    public static String getUserStatusKey(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.CQ_USER_STATUS_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }

    public static String redisPointOneDayOfUser(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.REDIS_ADD_POINT).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }

    public static String getAdminLmsTokenKey(String prefixRedisKey) {
        return prefixRedisKey.concat(CommonConstant.LEARNING_ADMIN_TOKEN_KEY);
    }

    public static String getUserLmsTokenKey(String prefixRedisKey, Long userId, Long subSystem) {
        return prefixRedisKey.concat(CommonConstant.LEARNING_USER_TOKEN_KEY).concat(String.valueOf(subSystem))
                .concat(CommonConstant.COLON).concat(String.valueOf(userId));
    }
}
