package main.java.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("user_name")
    private String username;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("password")
    private String password;

    @JsonProperty("type")
    private String type;

    @JsonProperty("ip_Address")
    private String ipAddress;

    @JsonProperty("login")
    private String login;

    @JsonProperty("url")
    private String url;

    public UserLoginDTO(String password){
        this.password = password;
    }
}
