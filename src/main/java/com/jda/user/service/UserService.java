package com.jda.user.service;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;

public interface UserService {
	 void register(User user);
	  User validateUser(Login login) ;
}
