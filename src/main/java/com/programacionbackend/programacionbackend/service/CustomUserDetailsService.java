package com.programacionbackend.programacionbackend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;
import com.programacionbackend.programacionbackend.infraestructure.database.repository.UserEntityJpaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserEntityJpaRepository userEntityJpaRepository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
		UserEntity user = this.userEntityJpaRepository.findUserByEmail(username);

        if(user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(user.getEmail(), user.getPassword(), roles);
        }
		throw new UsernameNotFoundException("User not found with email: " + username);
	}
}
