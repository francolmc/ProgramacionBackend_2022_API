package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.like.LikeRepository;

@NoRepositoryBean()
public interface LikeEntityBaseJpaRepository<T extends Like> extends JpaRepository<T, Long>, LikeRepository<T> {
   
}
