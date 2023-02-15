package main.java.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingData {
    @JsonProperty("total_page")
    private Integer totalPage;

    @JsonProperty("responses")
    private Object responses;

    public PagingData(Integer totalPage, Object responses) {
        this.totalPage = totalPage;
        this.responses = responses;
    }
}
