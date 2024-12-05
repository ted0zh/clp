package com.learningPlatform.CLP.repository;

import com.learningPlatform.CLP.data.entity.Badges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesRepository extends JpaRepository<Badges,Integer> {
}
