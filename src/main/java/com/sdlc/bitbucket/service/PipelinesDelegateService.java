package com.sdlc.bitbucket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdlc.bitbucket.configuration.BitbucketClientConfiguration;
import com.sdlc.bitbucket.domain.dto.PipelineValue;
import com.sdlc.bitbucket.domain.dto.PipelinesResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PipelinesDelegateService {
    public static final int ROW_SIZE = 100;
    private final BitbucketClientConfiguration bitbucketClientConfiguration;

    public PipelinesResult getPipelinesResult(String repository, int page) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            log.info("delegateService:Bitbucket command:getPipelines Request with reposistory:"+ repository +" page:" + page);
            String response = bitbucketClientConfiguration.getBitbucketRestClient().getPipelines(repository, ROW_SIZE, page);
            return objectMapper.readValue(response, PipelinesResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PipelineValue> getRecursivePipelinesResult(List<PipelineValue> pipelineValues, String repository, Integer iteration) {
        PipelinesResult pipelinesResult = getPipelinesResult(repository, iteration);
        if (pipelinesResult.getValues() == null) return pipelineValues;
        pipelineValues.addAll(pipelinesResult.getValues());
        if (Math.round(pipelinesResult.getSize() / ROW_SIZE)+1 != iteration) {
            getRecursivePipelinesResult(pipelineValues, repository, iteration+1);
        }
        return pipelineValues;
    }
}
