package com.learningPlatform.CLP.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table
@Data
public class Badges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeId;

    private String badgeName;
    private Timestamp earnedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
}
