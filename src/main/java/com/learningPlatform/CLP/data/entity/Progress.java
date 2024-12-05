package com.learningPlatform.CLP.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table
@Data
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int progressId;

    private boolean status;
    private Timestamp completionDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Users user;
    @OneToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "lessonId")
    private Lessons lesson;


}
