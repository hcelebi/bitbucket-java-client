package io.github.hcelebi.bitbucket.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRepositories {
    private int size;
    private int page;
    private String projectKey;
}
