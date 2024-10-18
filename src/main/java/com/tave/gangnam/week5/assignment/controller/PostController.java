package com.tave.gangnam.week5.assignment.controller;

import com.tave.gangnam.week5.assignment.dto.PostDto;
import com.tave.gangnam.week5.assignment.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 등록 API
    @PostMapping
    public ResponseEntity<PostDto.Response> createPost(
            @RequestBody PostDto.Request requestDto
    ) {
        PostDto.Response responseDto = postService.createPost(requestDto);

        return ResponseEntity.ok(responseDto);
    }

}
