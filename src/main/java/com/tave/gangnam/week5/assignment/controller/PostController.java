package com.tave.gangnam.week5.assignment.controller;

import com.tave.gangnam.week5.assignment.dto.CommentRequestDTO;
import com.tave.gangnam.week5.assignment.dto.CommentResponseDTO;
import com.tave.gangnam.week5.assignment.dto.PostsRequestDTO;
import com.tave.gangnam.week5.assignment.dto.PostsResponseDTO;
import com.tave.gangnam.week5.assignment.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 등록 API
    @PostMapping
    public ResponseEntity<PostsResponseDTO> createPost(
            @RequestBody PostsRequestDTO requestDto
    ) {
        PostsResponseDTO responseDto = postService.createPost(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    // 특정 게시글 조회 API
    @GetMapping("/{postsId}")
    public ResponseEntity<PostsResponseDTO> getPost(
            @PathVariable Long postsId) {
        PostsResponseDTO response = postService.getPostById(postsId);
        return ResponseEntity.ok(response);
    }

    // 작성한 게시글 전체 조회 API
    @GetMapping("/{empNo}")
    public List<String> getPosts(
            @PathVariable String empNo
    ) {
        return postService.getPostsByEmpNo(empNo);
    }

    // 게시글 수정 API
    @PutMapping("/modify")
    public ResponseEntity<PostsResponseDTO> modifyPost(
            @RequestBody PostsRequestDTO requestDto
    ) {
        PostsResponseDTO response = postService.updatePost(requestDto);
        return ResponseEntity.ok(response);
    }

    // 댓글 등록 API
    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComment(
            @RequestBody CommentRequestDTO requestDto
    ) {
        CommentResponseDTO responseDto = postService.createComments(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 수정 API
}
