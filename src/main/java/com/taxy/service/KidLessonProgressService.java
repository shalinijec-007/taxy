package com.taxy.service;

import org.springframework.stereotype.Service;

import com.taxy.entity.KidLessonProgress;
import com.taxy.repository.KidLessonProgressRepository;

@Service
public class KidLessonProgressService {

    private final KidLessonProgressRepository progressRepository;

    public KidLessonProgressService(
            KidLessonProgressRepository progressRepository) {

        this.progressRepository = progressRepository;
    }
    
    // Check whether this kid has already completed this lesson
    public boolean hasCompletedLesson(Long kidId, Long lessonId) {

        return progressRepository
                .existsByKidIdAndLessonIdAndCompleted(
                        kidId,
                        lessonId,
                        true
                );
    }
    
    // Save that this kid has completed this lesson
    public KidLessonProgress markLessonCompleted(
            Long kidId,
            Long lessonId) {

        KidLessonProgress progress = new KidLessonProgress();

        progress.setKidId(kidId);
        progress.setLessonId(lessonId);
        progress.setCompleted(true);

        return progressRepository.save(progress);
    }
}