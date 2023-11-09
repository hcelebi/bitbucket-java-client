package com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.configuration;

import com.sdlc.enterpriseagile.delegate.bitbucket.src.main.java.com.sdlc.bitbucket.client.BitbucketRestClient;
import com.sdlc.enterpriseagile.delegate.jirav3.client.JiraV3RestClient;
import com.sdlc.enterpriseagile.delegate.jirav3.configuration.JiraV3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BitbucketClientConfiguration {
    private final BitbucketProperties bitbucketProperties;

    public BitbucketRestClient getBitbucketRestClient() {
        return new BitbucketRestClient(bitbucketProperties.getBaseUri(), bitbucketProperties.getToken(), bitbucketProperties.getWorkspace());
    }
}
