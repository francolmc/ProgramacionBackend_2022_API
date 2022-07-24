package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.post.PostRepository;

public interface PostEntityJpaRepository extends JpaRepository<Post, Long>, PostRepository {
    public Post savePost(Post post);
    public void deleteById(Long id); 
    public Set<Post> findPostsByUserEmail(String email);
    public Set<Post> findAllPosts();
    public Post findPostById(Long id);
}
