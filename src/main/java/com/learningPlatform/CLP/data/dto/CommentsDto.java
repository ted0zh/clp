package com.learningPlatform.CLP.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class CommentsDto {
    private String text;
    private Timestamp createdAt;


}
