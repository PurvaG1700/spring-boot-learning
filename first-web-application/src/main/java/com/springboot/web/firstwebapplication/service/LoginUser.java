package com.springboot.web.firstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginUser {
	public boolean validateUser(String userid,String password) {
		return userid.equalsIgnoreCase("in28Minutes") && password.equalsIgnoreCase("123");
	}

}
