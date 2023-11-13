package io.github.hcelebi.bitbucket.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hcelebi.bitbucket.domain.dto.PipelinesResult;
import io.github.hcelebi.bitbucket.domain.dto.RepositoriesResult;
import io.github.hcelebi.bitbucket.domain.request.GetRepositories;
import io.github.hcelebi.bitbucket.exception.BitbucketRunTimeException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class BitbucketRestClient {

    private final String baseUri;
    private final String token;
    private final String workspace;
    private final HttpClient client;

    public BitbucketRestClient(String baseUri, String token, String workspace, HttpClient httpClient) {
        this.baseUri = baseUri;
        this.token = token;
        this.workspace = workspace;
        this.client = httpClient;
    }

    public RepositoriesResult getRepositories(GetRepositories getRepositories) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String query = "?pagelen=" + getRepositories.getSize() + "&page=" + getRepositories.getPage();
            if (getRepositories.getProjectKey() != null) {
                query += "&q=project.key%3D%22" + getRepositories.getProjectKey() + "%22";
            }
            URI uri = URI.create(baseUri + "/repositories/" + workspace + query);
            HttpResponse<String> response = getHttpResponse(uri);
            return objectMapper.readValue(response.body(), RepositoriesResult.class);
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BitbucketRunTimeException(e.getMessage());
        }
    }

    public PipelinesResult getPipelines(String repository, int size, int page) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URI uri = URI.create(baseUri + "/repositories/" + workspace + "/"+ repository +"/pipelines?pagelen=" + size + "&page=" + page);
            HttpResponse<String> response = getHttpResponse(uri);
            return objectMapper.readValue(response.body(), PipelinesResult.class);
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BitbucketRunTimeException(e.getMessage());
        }
    }

    private HttpResponse<String> getHttpResponse(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", "Basic " + token)
                .header("Content-Type", "application/json")
                .GET()
                .build(), BodyHandlers.ofString());
        return response;
    }
}
