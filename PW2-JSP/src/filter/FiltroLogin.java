package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltroLogin implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Iniciando FiltroLogin");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Filtrando posible Login: "+uri);
		
		String action = req.getParameter("action");
		HttpSession session = req.getSession(false);
		
		if( session == null && action != null && !action.equals("login") ){
			this.context.log("Unauthorized access request");
			res.sendRedirect("Login.jsp");
			
		} else if ( session != null && session.getAttribute("loggedUser") != null &&
				(uri.endsWith("Login.jsp") || uri.endsWith("ValidarServlet"))){
			res.sendRedirect("UsuarioValido.jsp");
			
		} else {
			// Esto permite que si existe otro filtro lo llame antes del servlet
			chain.doFilter(request, response);
		}
		
	}

	public void destroy() {
		this.context.log("Destruyendo FiltroLogin");
	}

}
