package com.learningPlatform.CLP.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LessonContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonContentId;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonIgnore
    private Lessons lesson;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContentType contentType;

    @Column(nullable = false)
    private String contentData; // For CODE_EXERCISE, this could be the problem statement.

    // Optional fields for coding challenges
    @Column
    private String starterCode;

    @Column
    private String expectedOutput;

}
