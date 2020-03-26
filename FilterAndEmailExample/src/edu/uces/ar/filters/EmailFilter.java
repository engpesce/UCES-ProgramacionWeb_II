package edu.uces.ar.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter encargado de validar que el mail esté bien formado
 */
@WebFilter("/sendEmail")
public class EmailFilter implements Filter {

    public EmailFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
	}
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		if (request.getParameter("mailFrom") != null && !request.getParameter("mailFrom").isEmpty() &&
				request.getParameter("mailTo") != null && !request.getParameter("mailTo").isEmpty() &&
				request.getParameter("subject") != null && !request.getParameter("subject").isEmpty() &&
				request.getParameter("message") != null && !request.getParameter("message").isEmpty()){
			request.setAttribute("isValidRequest", true);
		}else{
			request.setAttribute("isValidRequest", false);
		}
		
		// Esto permite que si existe otro filtro lo llame antes del servlet
		chain.doFilter(request, response);
	}

}
