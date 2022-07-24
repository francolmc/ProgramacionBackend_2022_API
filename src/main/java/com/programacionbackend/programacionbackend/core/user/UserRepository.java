package com.programacionbackend.programacionbackend.core.user;

public interface UserRepository {
    public User saveUser(User user);
    public User findUserByEmail(String email);
}
