package com.learningPlatform.CLP.service;

import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.dto.LessonsDto;
import com.learningPlatform.CLP.data.entity.Lessons;
import com.learningPlatform.CLP.exceptions.NoSuchLessonException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LessonsService {
    Lessons createLesson(LessonsDto dto);
    Lessons updateLesson(Integer id, LessonsDto dto) throws NoSuchLessonException;
    List<Lessons> fetchLessons();
    Optional<Lessons> getLesson(Integer id);
    void deleteLesson(Integer id);
}
