package com.learningPlatform.CLP.service;

import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.entity.LessonContent;

public interface LessonContentService {
   LessonContent createContent(LessonContentDto dto,int lessonId);
}
