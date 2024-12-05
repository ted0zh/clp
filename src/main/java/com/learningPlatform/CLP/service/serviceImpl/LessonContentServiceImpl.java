package com.learningPlatform.CLP.service.serviceImpl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.entity.LessonContent;
import com.learningPlatform.CLP.data.entity.Lessons;
import com.learningPlatform.CLP.data.mapper.LessonContentMapper;
import com.learningPlatform.CLP.repository.LessonContentRepository;
import com.learningPlatform.CLP.repository.LessonsRepository;
import com.learningPlatform.CLP.service.LessonContentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonContentServiceImpl implements LessonContentService {
    private final LessonContentRepository lessonContentRepository;
    private final LessonsRepository lessonsRepository;
    private final LessonContentMapper mapper;
    public LessonContentServiceImpl(LessonContentRepository lessonContentRepository, LessonsRepository lessonsRepository, LessonContentMapper mapper) {
        this.lessonContentRepository = lessonContentRepository;
        this.lessonsRepository = lessonsRepository;
        this.mapper = mapper;
    }

    @Override
    public LessonContent createContent(LessonContentDto dto,int lessonId) {
        LessonContent lessonContent = mapper.toEntity(dto);
        Optional<Lessons> lessonsOptional = lessonsRepository.findById(lessonId);
        if(lessonsOptional.isPresent()) {
            Lessons lesson = lessonsOptional.get();
            lessonContent.setLesson(lesson);
        }

        return lessonContentRepository.save(lessonContent);
    }
}
