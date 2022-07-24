package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import javax.transaction.Transactional;

import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;

@Transactional()
public interface UserEntityJpaRepository extends UserEntityBaseJpaRepository<UserEntity> {
    
}
