package com.cap.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.domain.Login;
import com.cap.domain.User;

import comp.cap.db.UserDAO;
import comp.cap.db.UserDAODynamoDB;
import comp.cap.util.Encryption;

@RestController
@RequestMapping(value="service/user")
public class UserService {

	private UserDAO userDAO = new UserDAODynamoDB();
	
	//TODO: Deprecate?
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable int id){
		return null;
	}
	
	//TODO: Deprecate?
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<User> getUsers(){
		Logger.getLogger(UserService.class.getName()).log(Level.INFO, "getUsers");
		return userDAO.getUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void putUser(@Valid @RequestBody User user){
		Logger.getLogger(UserService.class.getName()).log(Level.INFO, "putUser");
		userDAO.addUser(user);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(@Valid @RequestBody Login login){
		Logger.getLogger(UserService.class.getName()).log(Level.INFO, "login");
		User user = userDAO.getUser(login.getEmail());
		if(user!=null){
			if(Encryption.cryptWithMD5(login.getPassword()).equals(user.getPassword())){
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
