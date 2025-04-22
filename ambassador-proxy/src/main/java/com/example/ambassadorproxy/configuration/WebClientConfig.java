package com.example.ambassadorproxy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient.
 */
@Configuration
public class WebClientConfig
{

    @Value("${external.base-url}")
    private String baseUrl;

    /**
     * Creates a WebClient bean with the specified base URL.
     *
     * @param builder the WebClient.Builder instance
     * @return a WebClient instance
     */
    @Bean
    public WebClient webClient(WebClient.Builder builder)
    {
        return builder.baseUrl(baseUrl).build();
    }
}
