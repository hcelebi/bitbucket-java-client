package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestsResult implements Serializable {
    @Serial
    private static final long serialVersionUID = -5595702483305281606L;
    private int pagelen;
    private int size;
    private int page;
    private List<PullRequestValue> values;
}
