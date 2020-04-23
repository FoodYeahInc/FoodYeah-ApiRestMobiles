package com.example.service.impl;


import com.example.model.Post;
import com.example.repository.PostRepository;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }
}
