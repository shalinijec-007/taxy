package com.taxy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxy.entity.TaxLesson;
import com.taxy.repository.TaxLessonRepository;

@Service
public class TaxLessonService {
	
	 private final TaxLessonRepository taxLessonRepository;

	    // Spring automatically provides the repository here
	    public TaxLessonService(TaxLessonRepository taxLessonRepository) {
	        this.taxLessonRepository = taxLessonRepository;
	    }
	    
	    public List<TaxLesson> getLessonsForAge(Integer age) {

	        return taxLessonRepository
	                .findByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(age, age);
	    }
	    
	    public TaxLesson createLesson(TaxLesson lesson) {
	        return taxLessonRepository.save(lesson);
	    }

}
