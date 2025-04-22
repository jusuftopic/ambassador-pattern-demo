package com.example.clientservice.controller;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.clientservice.constants.ModuleConstants;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController
{
    private final WebClient webClient;

    public ClientController(WebClient webClient)
    {
        this.webClient = webClient;
    }

    @GetMapping("/data")
    public Mono<ResponseEntity<Map<String, String>>> getData()
    {
        return webClient.get()
            .uri(ModuleConstants.PROXY_API_URI)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
            .map(ResponseEntity::ok);
    }
}
