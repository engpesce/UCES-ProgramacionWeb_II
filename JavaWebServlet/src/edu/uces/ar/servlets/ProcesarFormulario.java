package edu.uces.ar.servlets;

import javax.servlet.http.HttpServlet;

public class ProcesarFormulario extends HttpServlet{

	private static final long serialVersionUID = 9097701561850818697L;

	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("Procesamiento correcto!!!!!");
		
	};
}
