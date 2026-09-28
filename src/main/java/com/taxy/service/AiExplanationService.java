package com.taxy.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AiExplanationService {

    private final RestClient restClient;

    public AiExplanationService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:11434")
                .build();
    }

    public String explainTax(String question, Integer age) {

        // Create a kid-friendly prompt for the local LLM
        String prompt =
                "You are Taxy, a friendly tax teacher for children. "
                + "Explain the following question to a " + age + "-year-old child. "
                + "Use simple words and one short real-life example. "
                + "Keep the answer short and easy to understand. "
                + "Question: " + question;

        // Request body sent to Ollama
        Map<String, Object> request = Map.of(
                "model", "llama3.2:1b",
                "prompt", prompt,
                "stream", false
        );

        // Call the local Ollama REST API
        OllamaResponse response = restClient.post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(OllamaResponse.class);

        // Return the generated explanation
        if (response == null || response.response() == null) {
            return "Sorry, I could not explain that right now.";
        }

        return response.response();
    }

    // Represents the part of Ollama's JSON response that we need
    private record OllamaResponse(String response) {
    }
}