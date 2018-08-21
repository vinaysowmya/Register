package com.jda.user.dao;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;

public interface UserDao{
	  void register(User user);
	   User validateUser(Login login) ;
		User findUserByEmail(String email);
		void update(String token, String email);
		public User getUserbyToken(String token) ;
		public void newPassword(String password,String token) ;
		public String generator(String password );
	}
