package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineValueStateResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 4982568041044843199L;

    private String name;
}
