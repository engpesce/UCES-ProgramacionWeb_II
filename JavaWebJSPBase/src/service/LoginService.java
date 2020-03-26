package service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LoginService {

	private final static String userOK = "admin";
	private final static String passOK = "admin";
	
	public static boolean validateLogin(String user, String pass) {
		
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
	
	public static Cookie login(HttpSession session, String user) {
		//FIXME: Guardar session!!
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(30*60); //Expira en 30 min
		
		Cookie userCookie = new Cookie("user", user);
		userCookie.setMaxAge(30*60);
		
		return userCookie;
	}
	
}
