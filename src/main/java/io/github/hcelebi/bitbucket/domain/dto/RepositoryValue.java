package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryValue implements Serializable {

    @Serial
    private static final long serialVersionUID = 9188309486380238548L;

    private String name;
}
