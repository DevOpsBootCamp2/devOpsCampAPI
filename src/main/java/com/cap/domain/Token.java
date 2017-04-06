package com.cap.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Token {

	@NotNull
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String token;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
