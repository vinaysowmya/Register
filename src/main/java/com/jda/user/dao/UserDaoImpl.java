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
	  
public  User forgotpassword(String email) {
	String sql = "select * from myuser where email='" + email+"'";
	
    
//   List<User> users = jdbcTemplate.query(sql, (ResultSetExtractor<List<User>>) new UserMapper());
   
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
  
    if (users.size() > 0)
    {
	
          System.out.println(users.get(0).getFirstname());
          return ( users).get(0);
    }
		return null;
	
}
@Override
public User findUserByEmail(String email) {
	String sql = "select * from myuser where email='" + email+"'";
	
   
// List<User> users = jdbcTemplate.query(sql, (ResultSetExtractor<List<User>>) new UserMapper());
 
	  List<User> users = jdbcTemplate.query(sql, new UserMapper());

  if (users.size() > 0)
  {
	
    //  System.out.println("Sagar");
        return   users.get(0);
  }
		return null;
	
	
}
@Override
public void update(String token, String email) {
	String sql = "update myuser set token='"+token+"' where email='" + email+"'";
 // jdbcTemplate.query(sql, new UserMapper());
	jdbcTemplate.update(sql);

}
public User getUserbyToken(String token) {
	   String sql = "select * from myuser where token='" + token 
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	    }
public void newPassword(String password,String token) {
	String sql="update myuser set password='"+password +"'  where token='"+token+"'";
	jdbcTemplate.update(sql);
}
}
	  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getString("phone"));
	    user.setToken(rs.getString("token"));
	    return user;
	    
	  }
	  }
	  
	
	

