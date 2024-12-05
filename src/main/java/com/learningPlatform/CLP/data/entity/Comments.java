package com.learningPlatform.CLP.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private String text;
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "lessonId")
    private Lessons lesson;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;


}
