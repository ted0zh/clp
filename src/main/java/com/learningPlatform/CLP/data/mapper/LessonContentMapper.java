package com.learningPlatform.CLP.data.mapper;

import com.learningPlatform.CLP.data.dto.LessonContentDto;
import com.learningPlatform.CLP.data.entity.LessonContent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonContentMapper {
    @Mapping(source = "contentData",target = "contentData")
    LessonContent toEntity(LessonContentDto dto);
}
