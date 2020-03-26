package edu.uces.ar.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uces.ar.services.SendEmailService;
import edu.uces.ar.services.SendEmailServiceImpl;

/**
 * Servlet encargado de enviar el email
 */
@WebServlet("/sendEmail")
public class EmailSenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SendEmailService emailService;
       
    public EmailSenderServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	this.emailService = new SendEmailServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if ( Boolean.valueOf(String.valueOf(request.getAttribute("isValidRequest"))) ){
			this.emailService.sendEmail(request.getParameter("mailFrom"), request.getParameter("mailTo"), 
					request.getParameter("subject"), request.getParameter("message"));
		}
		
		request.getRequestDispatcher("SendEmail.jsp").forward(request, response);
	}

}
