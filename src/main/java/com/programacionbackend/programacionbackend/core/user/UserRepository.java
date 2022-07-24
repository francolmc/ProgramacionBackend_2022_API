package com.programacionbackend.programacionbackend.core.user;

public interface UserRepository {
    public User create(User user);
    public User update(String email, User user);
    public User getUserByEmail(String email);
}
