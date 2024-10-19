package com.tave.gangnam.week5.assignment.service;

import com.tave.gangnam.week5.assignment.domain.Comments;
import com.tave.gangnam.week5.assignment.domain.CommentsMapper;
import com.tave.gangnam.week5.assignment.domain.Employee;
import com.tave.gangnam.week5.assignment.domain.Posts;
import com.tave.gangnam.week5.assignment.dto.CommentRequestDTO;
import com.tave.gangnam.week5.assignment.dto.CommentResponseDTO;
import com.tave.gangnam.week5.assignment.dto.PostsRequestDTO;
import com.tave.gangnam.week5.assignment.dto.PostsResponseDTO;
import com.tave.gangnam.week5.assignment.exception.PostException;
import com.tave.gangnam.week5.assignment.repository.CommentsRepository;
import com.tave.gangnam.week5.assignment.repository.EmployeeRepository;
import com.tave.gangnam.week5.assignment.repository.PostsRepository;
import com.tave.gangnam.week5.assignment.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;
    private final EmployeeRepository employeeRepository;
    private final CommentsRepository commentsRepository;

    // 게시글 등록 서비스
    @Transactional
    public PostsResponseDTO createPost(PostsRequestDTO request) {
        log.info("게시글 등록 시작");
        Posts newPost = Posts.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .postedAt(LocalDate.now())
                        .build();
        postsRepository.save(newPost);
        log.info("게시글 등록 완료");
        return PostsResponseDTO.toDto(newPost);
    }

    // 게시글 아이디로 조회 서비스
    @Transactional(readOnly = true)
    public PostsResponseDTO getPostById(Long postsId) {
        log.info("특정 게시글 조회 시작");
        return PostsResponseDTO.toDto(
                postsRepository.findById(postsId)
                        .orElseThrow(() -> new PostException(ErrorCode.POSTS_NOT_FOUND))
        );
    }

    // 자신이 작성한 게시글 조회 서비스
    @Transactional(readOnly = true)
    public List<String> getPostsByEmpNo(String empNo) {
        log.info("작성한 게시글 조회 시작");
        // 모든 데이터를 가져오는 것이 아닌 페이징 기능을 통해 일부 가져오기
        Pageable limit = PageRequest.of(0, 10);
        Page<Posts> posts = this.postsRepository.findAllByEmployeeNo(empNo, limit);

        log.info("사원번호" + empNo + "로 작성 게시글 확인하기");
        return posts.stream()
                .map(e -> e.getTitle())
                .collect(Collectors.toList());
    }

    // 게시글 수정 서비스
    @Transactional
    public PostsResponseDTO updatePost(PostsRequestDTO request) {
        log.info("게시글 수정 시작");
        // 수정하려는 게시글 조회
        log.info("수정 게시글 찾기");
        Posts findPost = postsRepository.findById(request.getPostsId())
                .orElseThrow(() -> new PostException(ErrorCode.POSTS_NOT_FOUND));

        // 작성자 본인이 맞는지 확인
        log.info("작성자 본인 확인");
        String empNo = findPost.getEmployeeNo(); // 게시글을 작성한 사람의 사원번호
        Employee emp = employeeRepository.findByEmployeeNo(empNo)
                .orElseThrow(() -> new PostException(ErrorCode.USER_NOT_FOUND));
        // 입력한 비밀번호가 맞는지를 확인
        if (emp.getPassword() != request.getPassword()) { // 작성자 비밀번호 확인
            throw new PostException(ErrorCode.WRONG_PASSWORD);
        }

        // 게시글 수정
        findPost.update(request.getTitle(), request.getContent());
        postsRepository.save(findPost);

        return PostsResponseDTO.toDto(findPost);
    }

    // 댓글 등록 서비스
    @Transactional
    public CommentResponseDTO createComments(CommentRequestDTO request) {
        log.info("댓글 등록 서비스 시작 >>>");

        // 등록하려는 게시글 찾기
        log.info("등록하려는 게시글 찾기");
        Posts findPost = postsRepository.findById(request.getPostsId())
                .orElseThrow(() -> new PostException(ErrorCode.POSTS_NOT_FOUND));

        // 댓글 등록하기
        log.info("댓글 등록하기");
        Comments newComment = CommentsMapper.toEntity(request, findPost);
        commentsRepository.save(newComment);

        // 반환
        return CommentsMapper.toDto(newComment);
    }
}
