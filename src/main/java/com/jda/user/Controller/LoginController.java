package com.jda.user.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;
import com.jda.user.dao.UserDao;
import com.jda.user.dao.UserDaoImpl;
import com.jda.user.service.UserService;
import com.jda.user.service.UserServiceImpl;

@Controller
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/")
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	
	@RequestMapping(value = "/loginProcess")
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) throws IOException {
	    ModelAndView mav = null;
	    User user = userService.validateUser(login);
	    if (null != user) {
	   	 HttpSession session=request.getSession();
	   	 session.setAttribute("name", user.getFirstname());
	  	// response.sendRedirect("/welcome");
	    
	   	 
    mav = new ModelAndView("redirect:/welcome");
	//    mav.addObject("firstname", user.getFirstname());
	    } 
	    
	   	 else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    } 
	    return mav;
	  }

}