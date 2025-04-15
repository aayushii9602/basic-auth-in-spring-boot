package com.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import com.auth.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUsers() {
		return this.userRepository.findAll();
	}

	public Optional<UserEntity> userExists(UserEntity user) {
		return this.userRepository.findByEmail(user.getEmail());
	}

	public UserEntity addUser(UserEntity user) {
		return this.userRepository.save(user);
	}

}
