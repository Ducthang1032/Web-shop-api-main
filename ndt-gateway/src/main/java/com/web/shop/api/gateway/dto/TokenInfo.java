package com.web.shop.api.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo {

    @JsonProperty("id")
    private String Id;

    @JsonProperty("user_name")
    private String userName;
}
