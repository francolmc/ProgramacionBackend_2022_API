package com.programacionbackend.programacionbackend.infraestructure.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programacionbackend.programacionbackend.config.JwtUtil;
import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.infraestructure.database.model.UserEntity;
import com.programacionbackend.programacionbackend.service.CustomUserDetailsService;
import com.programacionbackend.programacionbackend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

    @Autowired
    private UserService _userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
            return ResponseEntity.ok(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())));
			// authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		/* final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token)); */
	}

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody CreateUserDto user) {
        UserEntity u = new UserEntity();
        u.setEmail(user.email);
        u.setFirstName(user.firstName);
        u.setLastName(user.lastName);
        u.setPassword(user.password);
        return ResponseEntity.ok(this._userService.create(u));
    }
}
