package edu.uces.ar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEscupeHTML extends HttpServlet{

	private static final long serialVersionUID = -350280961535813669L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		writer.println("<!DOCTYPE html>");
		
		writer.println("<html lang=\"es\">");
			writer.println("<head>");
				writer.println("<meta charset=\"utf-8\">");
				writer.println("<title>Formularios HTML</title>");
				writer.println("<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\">");
			writer.println("</head>");
		
			writer.println("<body>");
				writer.println("<div>");
					writer.println("<h2>Formulario escrito desde un Servlet!</h2>");
					writer.println("<p>Si bien no es nada práctico podemos escribir HTML de manera dinámica</p>");
					writer.println("<form action=\"process\" method=\"post\">");
						writer.println("<fieldset>");
							writer.println("<legend>Información de contacto:</legend>");
							writer.println("<label for=\"nombre\">Nombre:</label>");
							writer.println("<input type=\"text\" name=\"nombre\">");
							writer.println("<label for=\"nombre\">Apellido:</label>");
							writer.println("<input type=\"text\" name=\"apellido\">");
							writer.println("<input type=\"submit\" value=\"enviar\">");
						writer.println("</fieldset>");
					writer.println("</form>");
				writer.println("</div>");
			writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		writer.println("Método POST No implementado");
		writer.close();
	
	}

}
