package com.tave.gangnam.week5.assignment.repository;

import com.tave.gangnam.week5.assignment.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
