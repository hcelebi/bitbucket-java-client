package com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineValueState implements Serializable {

    @Serial
    private static final long serialVersionUID = 7218298035210598909L;
    private String name;
    private PipelineValueStateResult result;
}
