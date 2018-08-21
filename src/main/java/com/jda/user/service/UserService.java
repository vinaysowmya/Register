package com.jda.user.service;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;

public interface UserService {
	 void register(User user);
	  User validateUser(Login login) ;
	User findUserByEmail(String email) ;
	void newPassword(String password, String token);
	User getUserbyToken(String resettoken);
	
}
