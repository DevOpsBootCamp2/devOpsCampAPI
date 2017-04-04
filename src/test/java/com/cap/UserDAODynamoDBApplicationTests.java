package com.cap;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cap.domain.User;
import comp.cap.db.UserDAODynamoDB;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAODynamoDBApplicationTests { 

	User user = new User("temp","temp","temp_password","temp@email.com");
	UserDAODynamoDB userDAODynamoDB = new UserDAODynamoDB();
	
	@Test
	public void createUser() {
		equals(userDAODynamoDB.addUser(user)); 
	}
	
	@Test 
	public void deleteUser(){
		equals(userDAODynamoDB.deleteUser(user));
	}

}
