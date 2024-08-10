package io.github.hcelebi.bitbucket.domain.request;

import lombok.Data;

@Data
public class GetPullRequests {
    private int pagelen;
    private int page;
    private String repository;
    private String q;
    private String state;
    private String user;
}
