package com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesResult implements Serializable {
    @Serial
    private static final long serialVersionUID = -3921835698629684358L;

    private int pagelen;
    private int size;
    private int page;
    private List<RepositoryValue> values;
}
