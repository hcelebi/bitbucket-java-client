package com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.configuration.BitbucketClientConfiguration;
import com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.domain.dto.RepositoriesResult;
import com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.domain.request.GetRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RepositoryDelegateService {

    private final BitbucketClientConfiguration bitbucketClientConfiguration;

    public RepositoriesResult getRepositories(GetRepositories getRepositories) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            log.info("delegateService:Bitbucket command:getRepositories Request with size:" + getRepositories.getSize() + " page:" + getRepositories.getPage() + " projectKey:" + getRepositories.getProjectKey());
            String response = bitbucketClientConfiguration.getBitbucketRestClient().getRepositories(getRepositories);
            return objectMapper.readValue(response, RepositoriesResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
