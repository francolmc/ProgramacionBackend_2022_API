package com.programacionbackend.programacionbackend.core.user;

public class UserDomain {
    private UserRepository _userRepository;

    public UserDomain(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public User create(User user) {
        // TODO: Encriptar contraseña
        return this._userRepository.create(user);
    }

    public User update(String email, User user) {
        User updateUser = this._userRepository.getUserByEmail(email);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        return this._userRepository.update(email, updateUser);
    }

    public User getUserByEmail(String email) {
        return this._userRepository.getUserByEmail(email);
    }

    public User changePassword(String email, String newPassword) {
        User user = this.getUserByEmail(email);
        // TODO: Encriptar contraseña
        user.setPasswordName(newPassword);
        return this.update(email, user);
    }

    public Boolean isValidUserPassword(String email, String password) {
        User user = this.getUserByEmail(email);
        if(user == null) return false;
        // TODO: Comparar contraseñas encriptadas
        return user.getPasswordName() == password;
    }
}
