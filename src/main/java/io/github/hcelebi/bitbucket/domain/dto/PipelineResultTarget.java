package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineResultTarget implements Serializable {
    @Serial
    private static final long serialVersionUID = -4565137314729441702L;
    private String ref_name;
    private PipelineResultTargetSelector selector;
}
