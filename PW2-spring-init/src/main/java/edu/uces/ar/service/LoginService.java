package edu.uces.ar.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private final static String userOK = "admin";
	private final static String passOK = "admin";
	
	public LoginService() {
		super();
	}

	public boolean validateLogin(String user, String pass) {
		
		if (user != null && pass != null) {
			
			if(userOK.equals(user) && passOK.equals(pass)) {
				return true;

			} else {
				return false;
			}
			
		}else {
			return false;
		}
		
		
	}
	
	public boolean isLogged(HttpSession session) {
		
		if (session != null && session.getAttribute("user") != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public Cookie login(HttpSession session, String user) {
		//FIXME: Guardar session!!
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(2*60); //Expira en 2 min
		
		Cookie userCookie = new Cookie("user", user);
		userCookie.setMaxAge(2*60);
		
		return userCookie;
	}
	
}
