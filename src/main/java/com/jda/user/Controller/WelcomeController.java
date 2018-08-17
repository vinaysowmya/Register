package com.jda.user.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.Model.User;
import com.jda.user.service.UserService;

@Controller
public class WelcomeController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/welcome")
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
	  ModelAndView mav = new ModelAndView("welcome"," name ",name);
	  //  mav.addObject("user", new User());
	    return mav;
	  }

}
