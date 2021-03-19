package com.example.demo.controller;

import java.util.Map;

import com.example.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MailController {

	//@Autowired
	//private MailServices mailService;
	@Autowired
	EmailSenderService emailSenderService ;
	@RequestMapping(value="/")
	public String homePage()
	{
		return "index"; 
	}
	
	@RequestMapping(value="/forgotPassword")
	public String forgotPassword()
	{
		return "forgotPassword"; 
	}
	
	@RequestMapping(value="/resetPassword" , method=RequestMethod.POST)
	public String resetRequest(@RequestParam String email)
	{
		//check if the email id is valid and registered with us.
		//mailService.sendMail(email);
		
		
		emailSenderService.sendSimpleEmail(email,
				"For reset password click on below link... "
					,"From Covax!!!");
		return "checkMail";
	}
	
	@RequestMapping(value="/newPassword/{email}" )
	public String resetPassword(@PathVariable String email,Map<String,String> model)
	{
		//check if the email id is valid and registered with us.
		model.put("emailid", email);
		return "newPassword";
	}

}

