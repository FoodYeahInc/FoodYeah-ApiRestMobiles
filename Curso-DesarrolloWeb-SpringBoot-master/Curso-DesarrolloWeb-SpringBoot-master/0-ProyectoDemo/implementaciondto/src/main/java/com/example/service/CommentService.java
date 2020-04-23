package com.example.service;

import com.example.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface CommentService {
    Comment save(Comment comment) ;
    Optional<Comment> findById(Long id) ;
    Page<Comment> findAll(Pageable pageable) ;
    void delete(Comment comment) ;

    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);

}
