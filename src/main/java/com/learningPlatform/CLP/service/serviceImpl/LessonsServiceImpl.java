package com.learningPlatform.CLP.service.serviceImpl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.dto.LessonsDto;
import com.learningPlatform.CLP.data.entity.LessonContent;
import com.learningPlatform.CLP.data.entity.Lessons;
import com.learningPlatform.CLP.data.entity.Users;
import com.learningPlatform.CLP.data.mapper.LessonsMapper;
import com.learningPlatform.CLP.exceptions.NoSuchLessonException;
import com.learningPlatform.CLP.repository.LessonContentRepository;
import com.learningPlatform.CLP.repository.LessonsRepository;
import com.learningPlatform.CLP.repository.UserRepository;
import com.learningPlatform.CLP.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonsServiceImpl implements LessonsService {

    private final LessonsRepository lessonsRepository;
    private final UserRepository userRepository;
    private final LessonsMapper lessonsMapper;

    @Autowired
    public LessonsServiceImpl(LessonsRepository lessonsRepository, UserRepository userRepository, LessonsMapper lessonsMapper) {
        this.lessonsRepository = lessonsRepository;
        this.userRepository = userRepository;
        this.lessonsMapper = lessonsMapper;
    }

    @Override
    public Lessons createLesson(LessonsDto dto) {
        // Fetch the user from the database using the userId from DTO
        Users user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));


        Lessons lesson = lessonsMapper.toEntity(dto);
        lesson.setUser(user);

        // Save and return the lesson
        return lessonsRepository.save(lesson);
    }


    @Override
    public Lessons updateLesson(Integer id, LessonsDto dto) throws NoSuchLessonException {
        return null;
    }

    @Override
    public List<Lessons> fetchLessons() {
        return lessonsRepository.findAll();
    }

    @Override
    @JsonIgnore
    public Optional<Lessons> getLesson(Integer id) {
        return lessonsRepository.findById(id);
    }

    @Override
    public void deleteLesson(Integer id) {
        lessonsRepository.deleteById(id);
    }
}
