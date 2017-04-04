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
	//TODO: DO NOT HARDCODE VALUE!!!!!!!!!!!! GET FROM APPLICATION.PROPERTIES INSTEAD
	private final String internalToken="abc123";
	
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
	
	public boolean isTokenValid(){
		boolean result=false;
		System.out.println("Token: "+token+" | Internal Token: "+internalToken);
		if(this.token.equals(internalToken)){
			result=true;
		}
		return result;
	}
}
