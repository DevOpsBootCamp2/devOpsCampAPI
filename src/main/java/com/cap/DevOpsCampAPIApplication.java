package com.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cap.datastore.NoSQL;
import com.cap.domain.User;

@SpringBootApplication
public class DevOpsCampAPIApplication {

	public static void main(String[] args) {
		
		NoSQL data = NoSQL.getInstance();
		User user0 = new User();
		user0.setId(0);
		user0.setFirstName("harvey0");
		user0.setLastName("Bal0");
		user0.setPassword("password0");
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("harvey1");
		user1.setLastName("Bal1");
		user1.setPassword("password1");
		
		data.putUser(user0);
		data.putUser(user1);
		
		SpringApplication.run(DevOpsCampAPIApplication.class, args);
	}
}
