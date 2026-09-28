package com.taxy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxy.service.KidLessonProgressService;

@RestController
@RequestMapping("/api/progress")
public class KidLessonProgressController {

    private final KidLessonProgressService progressService;

    public KidLessonProgressController(
            KidLessonProgressService progressService) {

        this.progressService = progressService;
    }

    @GetMapping("/{kidId}/lessons/{lessonId}")
    public ResponseEntity<Boolean> hasCompletedLesson(
            @PathVariable Long kidId,
            @PathVariable Long lessonId) {

        boolean completed =
                progressService.hasCompletedLesson(kidId, lessonId);

        return ResponseEntity.ok(completed);
    }
}