package com.coforge.Day_07_07_26_Exception;

import java.io.IOException;

public class LoginSessionDemo {
	
	public static void validate(String uname, String pwd) {
		
		if(uname.equals("Hitesh") && pwd.equals("Hitesh123")) {
			try(LoginSession session = new LoginSession()){
				
				session.login();
				session.accessPages();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalide Credentials, No sessions");
		}
	}
	
	public static void main(String[] args) {
		
		String uname = "Hitesh", pwd = "Hitesh123";
		validate(uname,pwd);
	}
}
