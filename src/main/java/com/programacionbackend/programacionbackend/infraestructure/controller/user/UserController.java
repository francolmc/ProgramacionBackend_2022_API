package com.programacionbackend.programacionbackend.infraestructure.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;
import com.programacionbackend.programacionbackend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService _userService;

    @PutMapping("/{email}/update")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody UpdateUserDto user) {
        UserEntity u = new UserEntity();
        u.setFirstName(user.firstName);
        u.setLastName(user.lastName);
        return ResponseEntity.ok(this._userService.update(email, u));
    }
}
