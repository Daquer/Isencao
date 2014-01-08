package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UsuarioFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("username")==null
			&& (!req.getRequestURI().endsWith("/") && !req.getRequestURI().endsWith("Login") 
					&& !req.getRequestURI().endsWith("Start")))
		{					
			request.setAttribute("msg","Entre com login e senha");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			return;
		}

		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
