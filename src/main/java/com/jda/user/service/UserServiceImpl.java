package com.jda.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import com.jda.user.Model.Login;
import com.jda.user.Model.User;
import com.jda.user.dao.UserDao;
//import com.jda.user.dao.UserMapper;
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;
	
	  @Autowired
		 private  JdbcTemplate jdbcTemplate;

	public User validateUser(Login login) {
		return userdao.validateUser(login);
	}


	public void register(User user) {
	userdao.register(user);
		
	}


	@Override
	public User findUserByEmail(String email) 
	{
		User user = userdao.findUserByEmail(email);
		
		if(user == null){
			return null;
		}
		String token = UUID.randomUUID().toString();
		
		user.setToken(token);
		userdao.update(token,email);
		return user;
		
	}


	@Override
	public void newPassword(String password, String token) {
	userdao.newPassword(password, token);
		
	}


	@Override
	public User getUserbyToken(String resettoken) {
		User user=userdao.getUserbyToken(resettoken);
		return user;
	}



	
}
