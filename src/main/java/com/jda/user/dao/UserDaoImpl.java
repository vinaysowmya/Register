package com.jda.user.dao;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;

public class UserDaoImpl implements UserDao{

	  @Autowired
	 private  JdbcTemplate jdbcTemplate;
	
	
		@Override
		public void register(User user) {
			String sql = "insert into myuser values(?,?,?,?,?,?,?)";
		    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
		    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
			// TODO Auto-generated method stub
			
		}
		public  User validateUser(Login login) {
			String sql = "select * from myuser where username='" + login.getUsername() + "' and password='" + login.getPassword()
		    + "'";
			String s=login.getUsername() ;
			System.out.println(s);
		    
		//   List<User> users = jdbcTemplate.query(sql, (ResultSetExtractor<List<User>>) new UserMapper());
		   
			  List<User> users = jdbcTemplate.query(sql, new UserMapper());
		  
		    if (users.size() > 0)
		    {
			
		          System.out.println(users.get(0).getFirstname());
		          return ( users).get(0);
		    }
			else
				return null;
			
		}
	  }
	  class UserMapper implements RowMapper {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getString("phone"));
	    return user;
	  }
	  }
