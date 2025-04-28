package com.auth.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class JWTRequest {

	private String email;
	private String password;

}
