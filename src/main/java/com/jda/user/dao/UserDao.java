package com.jda.user.dao;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;

public interface UserDao{
	  void register(User user);
	   User validateUser(Login login) ;
	}
