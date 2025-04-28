package com.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.auth.entity.UserEntity;
import com.auth.service.UserService;

@Configuration
public class AuthSecurityConfig {

	@Autowired
	private UserService userService;

	@Bean
	public UserDetailsService userDetailService() {
		List<UserEntity> users = this.userService.getAllUsers();
		List<UserDetails> userDetailsList = users.stream().map(user -> User.builder().username(user.getUsername())
				.password(passwordEncoder().encode(user.getPassword())).roles("USER").build()).toList();

		return new InMemoryUserDetailsManager(userDetailsList);
	};

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests(auth -> auth.requestMatchers("/user/signup/**").permitAll()
				.anyRequest().authenticated())
				.httpBasic();
		return http.build();
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();

	}
}
