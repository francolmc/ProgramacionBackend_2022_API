package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import javax.transaction.Transactional;

import com.programacionbackend.programacionbackend.infraestructure.database.model.LikeEntity;

@Transactional()
public interface LikeEntityJpaRepository extends LikeEntityBaseJpaRepository<LikeEntity> {
    
}
