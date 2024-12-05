package com.learningPlatform.CLP.repository;

import com.learningPlatform.CLP.data.entity.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonContentRepository extends JpaRepository<LessonContent,Integer> {
}
