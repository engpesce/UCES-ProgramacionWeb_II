package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/controller")
public class ServletController extends HttpServlet{

	private static final long serialVersionUID = 2902058557282079917L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//guardar mediante scope application todos los usuarios logueados y mostrarlos en una tabla:
		String action = req.getParameter("action");
		
		if ( action != null && action.equals("login") ){
			req.setAttribute("showRecoveryLink", "true");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
			
		} else if ( action != null && action.equals("createUser") ){
			
		} else if ( action != null && action.equals("recoveryPassword") ){
			req.setAttribute("numero", 2500);
			req.getRequestDispatcher("RecoveryPassword.jsp").forward(req, resp);
		} else if ( action != null && action.equals("sendNotification") ){
			
		} else {
			//invalid action
		}
	}
}
