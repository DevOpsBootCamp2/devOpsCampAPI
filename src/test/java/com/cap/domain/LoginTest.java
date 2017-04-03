package com.cap.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginTest {

	@Test
	public void testLoginConstructedSuccessfully() {
		String email = "email";
		String password = "pasword";
		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		
		assertEquals(email,login.getEmail());
		assertEquals(password,login.getPassword());
	}

}
