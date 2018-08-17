package com.jda.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;
import com.jda.user.dao.UserDao;
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;

	public User validateUser(Login login) {
		return userdao.validateUser(login);
	}

	public void register(User user) {
	userdao.register(user);
		
	}
}
