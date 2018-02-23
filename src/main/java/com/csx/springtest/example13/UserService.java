package com.csx.springtest.example13;

import com.csx.springtest.example13.domain.User;
import org.springframework.stereotype.Service;



@Service
public class UserService {
   
	public void createUser(User user){
		System.out.println("save user.");
	}

	public User getUserById(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName("test");
		return user;
	}
}
