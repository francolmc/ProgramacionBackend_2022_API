package com.programacionbackend.programacionbackend.core.user;

public interface UserRepository <T extends User> {
    public T save(T user);
    public T findUserByEmail(String email);
}
