package com.example.service;

import com.example.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface PostService {

    Post save(Post post) ;
    Optional<Post> findById(Long id) ;
    Page<Post> findAll(Pageable pageable) ;
    void delete(Post post) ;

    boolean existsById(Long id);
}
