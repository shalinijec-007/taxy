package com.taxy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxy.entity.TaxLesson;

/*
 * Repository responsible for database operations
 * on the tax_lesson table.
 *
 * JpaRepository already provides methods such as:
 *
 * save()
 * findAll()
 * findById()
 * deleteById()
 */
public interface TaxLessonRepository
        extends JpaRepository<TaxLesson, Long> {
	
	// Find lessons suitable for the kid's age
	List<TaxLesson> findByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(
	        Integer age,
	        Integer ageAgain
	);

}
