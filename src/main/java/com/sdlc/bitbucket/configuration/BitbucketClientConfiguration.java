package com.sdlc.bitbucket.configuration;

import com.sdlc.bitbucket.client.BitbucketRestClient;
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
