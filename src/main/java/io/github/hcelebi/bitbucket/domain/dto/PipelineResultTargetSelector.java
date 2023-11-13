package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineResultTargetSelector implements Serializable {
    @Serial
    private static final long serialVersionUID = 939824615031648725L;
    private String pattern;
}
