Add Dependency and configure create instance

```xml
<dependency>
    <groupId>io.github.hcelebi</groupId>
    <artifactId>bitbucket-java-client</artifactId>
    <version>1</version>
</dependency>
```

```java
BitbucketRestClient client = new BitbucketRestClient("baseUri", "token", "workspace", HttpClient.newHttpClient());
```
