package com.auth.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.UserEntity;
import com.auth.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserEntity> getAllUser() {
		return this.userService.getAllUsers();
	}
	@PostMapping("/signup")
	public Boolean signUp(@RequestBody UserEntity user) {
		if (this.userService.userExists(user).isPresent())
			return false;

		user.setId(UUID.randomUUID());
		this.userService.addUser(user);
		return true;

	}

}
