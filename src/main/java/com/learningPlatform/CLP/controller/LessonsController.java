package com.learningPlatform.CLP.controller;

import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.dto.LessonsDto;
import com.learningPlatform.CLP.data.entity.LessonContent;
import com.learningPlatform.CLP.data.entity.Lessons;
import com.learningPlatform.CLP.service.serviceImpl.LessonContentServiceImpl;
import com.learningPlatform.CLP.service.serviceImpl.LessonsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@RestController
@RequestMapping("/api/lessons")
public class LessonsController {

    private final LessonsServiceImpl lessonServiceImpl;
    private final LessonContentServiceImpl lessonContentServiceImpl;

    public LessonsController(LessonsServiceImpl lessonService, LessonContentServiceImpl lessonContentServiceImpl) {
        this.lessonServiceImpl = lessonService;
        this.lessonContentServiceImpl = lessonContentServiceImpl;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getLesson(@RequestParam int
                                                   id){
        Optional<Lessons> lessonOpt = lessonServiceImpl.getLesson(id);
        Lessons lesson = lessonOpt.get();
        return ResponseEntity.ok(lesson);
    }

    @Secured("TEACHER")
    @PostMapping("/create")
    public ResponseEntity<?> createLesson(@RequestBody LessonsDto dto) {
        Lessons savedLesson = lessonServiceImpl.createLesson(dto);
        return ResponseEntity.ok(savedLesson);
    }
    @Secured("TEACHER")
    @PostMapping("/{lessonId}/content/create")
    public ResponseEntity<?> createLessonContent(@RequestBody LessonContentDto dto, @PathVariable int lessonId) {
        LessonContent savedContent = lessonContentServiceImpl.createContent(dto,lessonId);
        return ResponseEntity.ok(savedContent);
    }
    @Secured("TEACHER")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        //String filePath = fileStorageService.saveFile(file);
        //return ResponseEntity.ok(filePath);
        return null;
    }


}
