package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.post.PostRepository;

@NoRepositoryBean()
public interface PostEntityBaseJpaRepository<T extends Post> extends JpaRepository<T, Long>, PostRepository<T> {
    
}
