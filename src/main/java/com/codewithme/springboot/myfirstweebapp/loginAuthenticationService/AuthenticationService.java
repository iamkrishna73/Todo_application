package com.codewithme.springboot.myfirstweebapp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String userName, String password) {
		
		boolean isValidUserName = userName.equalsIgnoreCase("codewithme");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}
}