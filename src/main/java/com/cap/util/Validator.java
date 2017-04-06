package com.cap.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cap.domain.Token;

@Component
public class Validator {
	
	@Value("${domian.token}")
	private String internalToken;
	
	public boolean isTokenValid(Token token){
		boolean result=false;
		if(this.internalToken.equals(token.getToken())){
			result=true;
		}
		return result;
	}
}
