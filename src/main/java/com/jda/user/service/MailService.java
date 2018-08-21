package com.jda.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService{
	@Autowired
   public JavaMailSender mailSender;

   public void sendSimpleMessage(String to, String subject, String text) {
       
       SimpleMailMessage message = new SimpleMailMessage(); 
       message.setFrom("shravanbossu@gmail.com");
       message.setTo(to); 
       message.setSubject(subject); 
       message.setText(text);
      
       mailSender.send(message);
       
   }

}
