package main.java.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenInfo {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("sub_system")
    private Long subSystem;

    @JsonProperty("fcm_token")
    private String fcmToken;

    @JsonProperty("apns_token")
    private String apnsToken;

    @JsonProperty("platform")
    private String platform;

}
