package com.learningPlatform.CLP.data.dto;

import com.learningPlatform.CLP.data.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
@Getter
@Setter
public class LessonsDto {

    private String title;
    private String description;
    private int userId; // ID of the user who created the lesson
    private List<LessonContentDto> contents; // List of associated contents

}
