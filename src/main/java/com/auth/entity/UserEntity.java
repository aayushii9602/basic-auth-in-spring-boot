package com.auth.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class UserEntity {
	@Id
	private UUID id;
	private String username;
	private String password;
	private String role;
	private String email;
}
