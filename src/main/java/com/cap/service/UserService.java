package com.cap.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.datastore.NoSQL;
import com.cap.domain.User;

@RestController
@RequestMapping(value="service/user")
public class UserService {

	private NoSQL data = NoSQL.getInstance();
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable int id){
		return data.getUser(id);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public User[] getUsers(){
		return data.getUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void putUser(@RequestBody User user){
		data.putUser(user);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(@RequestBody User user){
		return data.getUser(user.getEmail(), user.getPassword());
	}
}
