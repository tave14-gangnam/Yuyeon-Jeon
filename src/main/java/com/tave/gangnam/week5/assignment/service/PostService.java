package com.tave.gangnam.week5.assignment.service;

import com.tave.gangnam.week5.assignment.domain.Posts;
import com.tave.gangnam.week5.assignment.dto.PostDto;
import com.tave.gangnam.week5.assignment.repository.PostsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;

    // 게시글 등록 서비스
    public PostDto.Response createPost(PostDto.Request request) {
        log.info("게시글 등록 시작");
        Posts newPost = Posts.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .postedAt(LocalDate.now())
                        .build();
        postsRepository.save(newPost);
        log.info("게시글 등록 완료");
        return PostDto.Response.toDto(newPost);
    }
}
