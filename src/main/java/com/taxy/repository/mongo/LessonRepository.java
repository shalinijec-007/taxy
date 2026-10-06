package com.taxy.repository.mongo;

import com.taxy.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository
        extends MongoRepository<Lesson, String> {
}