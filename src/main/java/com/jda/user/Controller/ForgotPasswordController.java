package com.jda.user.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.Model.Login;
import com.jda.user.Model.User;
import com.jda.user.service.MailService;
import com.jda.user.service.UserService;


@Controller
public class ForgotPasswordController {
	
	@Autowired
private UserService userService;
	@Autowired
	private MailService mailservice;
	
	@RequestMapping(value = "/forgotpassword")
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("forgotpassword");
	   // mav.addObject("register", new Login());
	    return mav;
	  }
	@RequestMapping(value = "/forgotpasswordProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	 @RequestParam("email")String email)
	  {
	//	logger.info(email);
		ModelAndView mav=null;
		User user=userService.findUserByEmail(email);
		if(user==null)
		{
			  mav = new ModelAndView("forgotpassword");
			    mav.addObject("message", "User not find with this email id!!");
			    return mav;
		}
		
		String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ request.getServletContext().getContextPath();

mailservice.sendSimpleMessage(user.getEmail(), "reset password", "To reset your password, click the link below:\n" + appUrl + "/resetpassword?resetToken="
				+ user.getToken());
		return null;
	}

}
