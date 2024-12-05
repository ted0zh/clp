package com.learningPlatform.CLP.repository;

import com.learningPlatform.CLP.data.entity.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons,Integer> {
}
