package com.springboot.web.firstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.firstwebapplication.service.LoginUser;

//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	LoginUser service ;
	//Model,
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String showLoginPage(ModelMap model){
//		model.put("name", name);
		return "login";
	}
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password){
		boolean isValidUser=service.validateUser(name, password);
		if(!isValidUser) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}
}