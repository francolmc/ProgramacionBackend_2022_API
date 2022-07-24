package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.like.LikeRepository;

public interface LikeEntityJpaRepository extends JpaRepository<Like, Long>, LikeRepository {
    public Like saveLike(Like like);
    public Like findLikeById(Long id);
    public Integer countLikesByPostId(Integer postId);
    public Like findLikeByPostIdAndUserEmail(Long postId, String email);
}
