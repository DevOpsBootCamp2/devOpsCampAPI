package com.cap.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.datastore.NoSQL;
import com.cap.domain.Login;
import com.cap.domain.User;

@RestController
@RequestMapping(value="service/user")
public class UserService {

	private NoSQL data = NoSQL.getInstance();
	
	//TODO: Deprecate?
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable int id){
		return data.getUser(id);
	}
	
	//TODO: Deprecate?
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public User[] getUsers(){
		return data.getUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void putUser(@Valid @RequestBody User user){
		data.putUser(user);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(@Valid @RequestBody Login login){
		return data.getUser(login.getEmail(), login.getPassword());
	}
}
