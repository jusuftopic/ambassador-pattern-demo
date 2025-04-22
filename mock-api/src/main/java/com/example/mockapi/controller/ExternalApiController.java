package com.example.mockapi.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for external API simulation.
 */
@RestController
@RequestMapping("/api/external")
public class ExternalApiController
{

    private final Random random = new Random();

    /**
     * Simulates an external API call.
     *
     * @return ResponseEntity with simulated data or error.
     */
    @GetMapping("/data")
    public ResponseEntity<Map<String, String>> getExternalData()
    {
        if (random.nextBoolean())
        {
            // Simulate failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Simulated failure"));
        } else
        {
            // Success
            return ResponseEntity.ok(Map.of("message", "Data from mock API"));
        }
    }
}
