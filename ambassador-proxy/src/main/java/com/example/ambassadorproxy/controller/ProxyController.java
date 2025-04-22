package com.example.ambassadorproxy.controller;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.ambassadorproxy.constants.ModuleConstants;

import reactor.core.publisher.Mono;

/**
 * Proxy Controller communicates with 3rd party API.
 */
@RestController
@RequestMapping("/proxy")
public class ProxyController
{
    private final WebClient webClient;

    public ProxyController(WebClient webClient)
    {
        this.webClient = webClient;
    }

    /**
     * Fetches data from the external API and handles errors.
     *
     * @return ResponseEntity with the data or a fallback response.
     */
    @GetMapping("/data")
    public Mono<ResponseEntity<Map<String, String>>> getData()
    {
        return webClient.get()
            .uri(ModuleConstants.EXTERNAL_API_URI)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>()
            {
            })
            .retry(3)
            .onErrorResume(error ->
            {
                Map<String, String> fallback = Map.of("message", "Fallback response");
                return Mono.just(fallback);
            })
            .map(ResponseEntity::ok);
    }
}
