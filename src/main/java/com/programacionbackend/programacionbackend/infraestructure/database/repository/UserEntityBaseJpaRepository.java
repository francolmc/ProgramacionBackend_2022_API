package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

@NoRepositoryBean()
public interface UserEntityBaseJpaRepository<T extends User> extends JpaRepository<T, Long>, UserRepository<T> {
}
