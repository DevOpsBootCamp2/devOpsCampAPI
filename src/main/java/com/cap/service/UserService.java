package com.cap.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.db.UserDAO;
import com.cap.db.UserDAODynamoDB;
import com.cap.domain.Token;
import com.cap.domain.User;
import com.cap.util.Encryption;
import com.cap.util.Validator;

@RestController
@RequestMapping(value="service/user")
public class UserService {
	
	@Autowired
	private Validator validator;
	private UserDAO userDAO = new UserDAODynamoDB();
	
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
	public User login(@Valid @RequestBody Token token){
		User user = null;
		if(validator.isTokenValid(token)){
			Logger.getLogger(UserService.class.getName()).log(Level.INFO, "Token Is Valid");
			User internalUser = userDAO.getUser(token.getEmail());
			if(internalUser!=null && Encryption.cryptWithMD5(token.getPassword()).equals(internalUser.getPassword())){
				user = internalUser;
			}
		}
		return user;
	}
	
}
