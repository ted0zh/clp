package com.learningPlatform.CLP.repository;

import com.learningPlatform.CLP.data.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}
