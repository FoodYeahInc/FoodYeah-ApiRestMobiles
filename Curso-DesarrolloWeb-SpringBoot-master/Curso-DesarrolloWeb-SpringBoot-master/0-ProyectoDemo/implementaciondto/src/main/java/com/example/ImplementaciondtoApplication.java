package com.example;

import com.example.model.Post;
import com.example.model.Tag;
import com.example.repository.PostRepository;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImplementaciondtoApplication implements CommandLineRunner {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImplementaciondtoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Cleanup the tables
        //postRepository.deleteAllInBatch();
        //tagRepository.deleteAllInBatch();

        // =======================================

        // Create a Post
        /*Post post = new Post();
        post.setTitle("Hibernate Many to Many Example with Spring Boot");
        post.setDescription("Learn how to map a many to many relationship using hibernate");
        post.setContent("Entire Post content with Sample code");*/

        // Create two tags
        /*Tag tag1 = new Tag();
        tag1.setName("Spring Boot");
        Tag tag2 = new Tag();
        tag2.setName("Hibernate");*/


        // Add tag references in the post
        /*post.getTags().add(tag1);
        post.getTags().add(tag2);*/

        // Add post reference in the tags
        /*tag1.getPosts().add(post);
        tag2.getPosts().add(post);

        postRepository.save(post);*/

        // =======================================

    }

}
