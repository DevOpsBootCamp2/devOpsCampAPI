package com.cap.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserTest {

	@Test
	public void testUserConstructedSuccessfully(){
		
		int id = 0;
		String firstName = "firstName";
		String lastName = "lastName";
		String email = "email";
		String password = "password";
		
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		assertEquals(id, user.getId());
		assertEquals(firstName, user.getFirstName());
		assertEquals(lastName, user.getLastName());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
	}
}
