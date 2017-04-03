package com.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cap.datastore.NoSQL;
import com.cap.domain.User;

import comp.cap.db.UserDAOImp;

@SpringBootApplication
public class DevOpsCampAPIApplication {

	public static void main(String[] args) {
		
		NoSQL data = NoSQL.getInstance();
		User user0 = new User();
		user0.setId(0);
		user0.setFirstName("harvey0");
		user0.setLastName("Bal0");
		user0.setPassword("password0");
		user0.setEmail("harevy0@email.com");
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("harvey1");
		user1.setLastName("Bal1");
		user1.setPassword("password1");
		user1.setEmail("harvey1@email.com");
		
		data.putUser(user0);
		data.putUser(user1);
		
		
		System.out.println();
		User user = new User("biniam", "gebreyesus", "yolo", "biniam@biniam.com");
		UserDAOImp userDAOImp = new UserDAOImp();
		userDAOImp.getUser(user.getEmail());
		userDAOImp.getUsers();
		
		userDAOImp.addUser(user);
		
		userDAOImp.getUser(user.getEmail());
		userDAOImp.getUsers();
		
		
		SpringApplication.run(DevOpsCampAPIApplication.class, args);
	}
}
