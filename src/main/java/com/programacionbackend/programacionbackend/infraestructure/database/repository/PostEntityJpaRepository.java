package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import javax.transaction.Transactional;

import com.programacionbackend.programacionbackend.infraestructure.database.model.PostEntity;

@Transactional()
public interface PostEntityJpaRepository extends PostEntityBaseJpaRepository<PostEntity> {
    
}
