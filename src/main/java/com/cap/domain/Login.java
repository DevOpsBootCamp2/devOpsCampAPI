package com.cap.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Login {

	@NotNull
	private String password;
	@NotNull
	@Email
	private String email;
	
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
}
