package com.jda.user.Controller;


	import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	import com.jda.user.Model.Login;
import com.jda.user.Model.User;
import com.jda.user.service.UserService;

	@Controller
	public class ResetPasswordController {
		
		@Autowired
	private UserService userService;
		
		@RequestMapping(value = "/resetpassword", method=RequestMethod.GET)
		  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response ,@RequestParam("resetToken") String resettoken) {
			ModelAndView mav = null;
		User user=userService.getUserbyToken(resettoken);
		
			if(user == null){
			
				mav=new ModelAndView("login");
				mav.addObject("message", "Oops!  This is an invalid password reset link.");
				mav.addObject("login", new Login());
				return mav;
			}
		mav=new ModelAndView("resetpassword");
		mav.addObject("resetToken",resettoken);

			return mav; 
		  } 

		@RequestMapping(value = "/resetpasswordProcess", method = RequestMethod.POST)
		public ModelAndView  addUser(HttpServletRequest request, HttpServletResponse response,
		      @RequestParam ("newpassword")String password ,@RequestParam Map<String, String> requestParams) throws IOException {
	//		logger.info(password);
			System.out.println();
			String token = requestParams.get("resetToken");
			ModelAndView mav = null;
			 userService.newPassword(password, token);
			mav= new ModelAndView("redirect:/");
			return mav;
		} 
}
