package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestValue implements Serializable {
    @Serial
    private static final long serialVersionUID = 2050451206571365657L;
    private Integer id;
    private String title;
    private String state;
}
