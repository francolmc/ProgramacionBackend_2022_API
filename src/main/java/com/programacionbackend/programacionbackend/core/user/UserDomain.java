package com.programacionbackend.programacionbackend.core.user;

public class UserDomain <U extends User> {
    private UserRepository<U> _userRepository;

    public UserDomain(UserRepository<U> userRepository) {
        this._userRepository = userRepository;
    }

    public U create(U user) {
        // TODO: Encriptar contraseña
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
        // TODO: Encriptar contraseña
        user.setPasswordName(newPassword);
        return this.update(email, user);
    }

    public Boolean isValidUserPassword(String email, String password) {
        U user = this.getUserByEmail(email);
        if(user == null) return false;
        // TODO: Comparar contraseñas encriptadas
        return user.getPasswordName() == password;
    }
}
