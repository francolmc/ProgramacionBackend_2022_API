package com.programacionbackend.programacionbackend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;
import com.programacionbackend.programacionbackend.infraestructure.database.repository.UserEntityJpaRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserEntityJpaRepository userEntityJpaRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userEntityJpaRepository.findUserByEmail(username);
		if (user != null) {
			return new User(user.getEmail(), user.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
