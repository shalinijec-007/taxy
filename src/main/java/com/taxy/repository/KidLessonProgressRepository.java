package com.taxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxy.entity.KidLessonProgress;

public interface KidLessonProgressRepository
        extends JpaRepository<KidLessonProgress, Long> {
	
	boolean existsByKidIdAndLessonIdAndCompleted(
	        Long kidId,
	        Long lessonId,
	        boolean completed
	);

}