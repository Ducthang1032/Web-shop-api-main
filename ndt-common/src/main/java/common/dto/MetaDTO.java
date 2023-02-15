package main.java.common.dto;

import com.tdt.cqsta.common.enums.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaDTO {
    private Integer code;
    private String message;

    public MetaDTO(MetaData metaData) {
        this.code = metaData.getMetaCode();
        this.message = metaData.getMessage();
    }
}
