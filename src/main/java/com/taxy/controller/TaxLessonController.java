package com.taxy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxy.entity.TaxLesson;
import com.taxy.service.TaxLessonService;

@RestController
@RequestMapping("/api/lessons")
public class TaxLessonController {
	
	private final TaxLessonService taxLessonService;

	// Spring injects TaxLessonService through the constructor
	public TaxLessonController(TaxLessonService taxLessonService) {
	    this.taxLessonService = taxLessonService;
	}
	
	@GetMapping
	public List<TaxLesson> getLessonsForAge(
	        @RequestParam Integer age) {

	    return taxLessonService.getLessonsForAge(age);
	}
	
	@PostMapping
	public TaxLesson createLesson(
	        @RequestBody TaxLesson lesson) {

	    return taxLessonService.createLesson(lesson);
	}

}