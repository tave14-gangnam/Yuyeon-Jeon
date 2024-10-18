package com.tave.gangnam.week5.assignment.repository;

import com.tave.gangnam.week5.assignment.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
