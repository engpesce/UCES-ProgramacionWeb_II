package edu.uces.ar.service;

import javax.servlet.http.HttpSession;

public class LogoutService {
	
	public static void logout(HttpSession session) {

    	if(session != null){
    		session.invalidate();
    	}
    	
	}

}
