package com.learningPlatform.CLP.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonContentDto {

    private String contentType; // e.g., TEXT, VIDEO, CODE_EXERCISE
    private String contentData; // Data for the content (text, URL, or code)
    private String starterCode; // For code exercises, optional starter code
    private String expectedOutput; // For code exercises, optional expected output


}
