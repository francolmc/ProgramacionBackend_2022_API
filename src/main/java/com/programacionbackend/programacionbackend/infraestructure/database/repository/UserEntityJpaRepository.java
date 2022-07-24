package com.programacionbackend.programacionbackend.infraestructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

public interface UserEntityJpaRepository extends JpaRepository<User, Long>, UserRepository {
    public User saveUser(User user);
    public User findUserByEmail(String email);
}
