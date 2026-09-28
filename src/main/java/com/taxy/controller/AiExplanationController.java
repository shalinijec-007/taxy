package com.taxy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxy.dto.AiExplanationRequest;
import com.taxy.service.AiExplanationService;

@RestController
@RequestMapping("/api/ai")
public class AiExplanationController {

    private final AiExplanationService aiExplanationService;

    public AiExplanationController(
            AiExplanationService aiExplanationService) {
        this.aiExplanationService = aiExplanationService;
    }

    @PostMapping("/explain")
    public ResponseEntity<String> explain(
            @RequestBody AiExplanationRequest request) {

        String explanation =
                aiExplanationService.explainTax(
                        request.getQuestion(),
                        request.getAge());

        return ResponseEntity.ok(explanation);
    }
}
