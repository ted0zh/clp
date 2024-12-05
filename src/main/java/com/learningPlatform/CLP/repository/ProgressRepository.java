package com.learningPlatform.CLP.repository;

import com.learningPlatform.CLP.data.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress,Integer> {
}
