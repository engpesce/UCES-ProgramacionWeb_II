package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import service.LogoutService;

@WebServlet(value="/controller")
public class ServletController extends HttpServlet{

	private static final long serialVersionUID = 2902058557282079917L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		
		if (action != null) {
			
			if ( action.equals("showLogin") ){
				if (!LoginService.isLogged(req.getSession())) {
					req.setAttribute("showRecoveryLink", "true");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
				} else {
					req.getRequestDispatcher("UsuarioValido.jsp").forward(req, resp);
				}
				
			} else if (action.equals("login")) {	
				
				if (LoginService.validateLogin(req.getParameter("name"), req.getParameter("pass"))) {
					
					Cookie userCookie = LoginService.login(req.getSession(false), req.getParameter("name"));
					resp.addCookie(userCookie);
					resp.sendRedirect("UsuarioValido.jsp");
					
				} else {
					req.setAttribute("usuarioMal", true);
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}
				
			} else if (action.equals("logout")) {	
				
				LogoutService.logout(req.getSession(false));
				resp.sendRedirect("Login.jsp");
				
			} else if ( action.equals("createUser") ){
				//Falta implementarlo (PARCIAL 1)
				
			} else if ( action.equals("recoveryPassword") ){
				resp.sendRedirect("RecoveryPassword.jsp");
				
			} else if ( action.equals("sendNotification") ){
				//Falta implementarlo (PARCIAL 1)
			}
			
		} else {
			//invalid action!
		}
		
		
	}
}
