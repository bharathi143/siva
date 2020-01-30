package com.lti.login;

import java.util.*;

public class UserService {
	
	private List<User> users;
	
	public UserService() {	 
		users = new ArrayList<User>();
		users.add(new User("bharathi","123",true));
		users.add(new User("pooja","345",true));
		users.add(new User("heroor","789",false));
		users.add(new User("siva","1234",false));
	}
	
	public boolean isValidUser(String username,String password){
		
		for(User str:users){
			if(str.getUsername().equals(username))
				if(str.getPassword().equals(password))
					if(str.isAllowed())
					return true;
		}
		return false;
		
	}


}
