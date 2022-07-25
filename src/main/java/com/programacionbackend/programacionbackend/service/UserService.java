package com.programacionbackend.programacionbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacionbackend.programacionbackend.core.user.UserDomain;
import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;
import com.programacionbackend.programacionbackend.infraestructure.database.repository.UserEntityJpaRepository;

@Service
public class UserService {
    @Autowired
    private UserDomain<UserEntity> _userDomain;
    @Autowired
    private UserEntityJpaRepository _userRepository;

    public UserService() {
        this._userDomain = new UserDomain<UserEntity>(_userRepository);
    }

    public UserEntity create(UserEntity user) {
        return this._userDomain.create(user);
    }

    public UserEntity update(String email, UserEntity user) {
        return this._userDomain.update(email, user);
    }
}
