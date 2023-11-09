package com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelinesResult implements Serializable {
    @Serial
    private static final long serialVersionUID = -5595702482205281606L;

    private int pagelen;
    private int size;
    private int page;
    private List<PipelineValue> values;
}
