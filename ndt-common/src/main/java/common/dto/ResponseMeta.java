package main.java.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class ResponseMeta {
    @JsonProperty("meta")
    private List<MetaDTO> meta;

    @JsonSetter
    public void setMeta(List<MetaDTO> meta) {
        this.meta = meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = Collections.singletonList(meta);
    }
}
