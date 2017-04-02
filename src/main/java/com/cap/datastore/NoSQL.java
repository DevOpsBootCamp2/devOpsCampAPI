package com.cap.datastore;

import java.util.HashMap;
import java.util.Map;

import com.cap.domain.User;

public class NoSQL {

	private static NoSQL instance = null;
	
	private Map<Integer, User> data = new HashMap<Integer, User>();
	
	private NoSQL(){}
	
	public static NoSQL getInstance(){
		if(instance==null){
			instance = new NoSQL();
		}
		return instance;
	}
	
	public User getUser(int id){
		return data.get(id);
	}
	
	public void putUser(User user){
		data.put(user.getId(), user);
	}
	
	public User[] getUsers(){
		User[] users = new User[data.size()];
		int index=0;
		for(Map.Entry<Integer, User> es : data.entrySet()){
			users[index]=es.getValue();
			index++;
		}
		return users;
	}
}
