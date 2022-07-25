package com.programacionbackend.programacionbackend.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDomain <U extends User> {
    private UserRepository<U> _userRepository;

    @Autowired
    private PasswordEncoder _bcrypEncoder;

    public UserDomain(UserRepository<U> userRepository) {
        this._userRepository = userRepository;
    }

    public U create(U user) {
        user.setPassword(this._bcrypEncoder.encode(user.getEmail()));
        return this._userRepository.save(user);
    }

    public U update(String email, U user) {
        U updateUser = this.getUserByEmail(email);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        return this._userRepository.save(updateUser);
    }

    public U getUserByEmail(String email) {
        return this._userRepository.findUserByEmail(email);
    }

    public U changePassword(String email, String newPassword) {
        U user = this.getUserByEmail(email);
        user.setPassword(this._bcrypEncoder.encode(newPassword));
        return this.update(email, user);
    }

    public Boolean isValidUserPassword(String email, String password) {
        U user = this.getUserByEmail(email);
        if(user == null) return false;
        return this._bcrypEncoder.matches(password, user.getEmail());
    }
}
