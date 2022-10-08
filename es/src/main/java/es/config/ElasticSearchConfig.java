package es.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author chase
 * @date 2022/9/26 5:30 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.elasticsearch.rest")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    private String uris;
    private String password;
    private String username;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost(uris, Integer.valueOf(uris.split(":")[1]), "http"))
                .setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(provider));
        return  new RestHighLevelClient(restClientBuilder);
    }


}
