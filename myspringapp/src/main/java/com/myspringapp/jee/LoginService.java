package com.myspringapp.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("admin") && password.equals("password");
	}

}