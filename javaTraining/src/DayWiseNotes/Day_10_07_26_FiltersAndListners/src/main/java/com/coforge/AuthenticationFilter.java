package com.coforge;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter("/Authentication")
@WebFilter({"/home.jsp,/info.jsp"})
public class AuthenticationFilter extends HttpFilter implements Filter {
       
    
	public AuthenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response; // Fixed here
		HttpSession session = req.getSession(false);
		
		if(session!=null && session.getAttribute("uname") != null) {
			
			System.out.println("filter executed");
			chain.doFilter(request, response);		
			
		}else {
			res.sendRedirect(req.getContextPath() + "/index.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
