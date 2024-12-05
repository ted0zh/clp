package com.learningPlatform.CLP.data.mapper;

import com.learningPlatform.CLP.data.dto.LessonsDto;
import com.learningPlatform.CLP.data.entity.Lessons;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonsMapper {
    @Mapping(source = "title",target = "title")
    Lessons toEntity(LessonsDto dto);

    LessonsDto toDto(Lessons lessons);
}
