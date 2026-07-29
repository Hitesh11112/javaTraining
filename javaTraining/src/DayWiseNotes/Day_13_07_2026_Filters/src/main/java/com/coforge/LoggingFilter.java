package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingFilter extends HttpFilter implements Filter {
       
    public LoggingFilter() {
        super();
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");		
		System.out.println("---------Logs----------------");
		System.out.println("Start Time" + LocalDateTime.now());
		
		System.out.println("URL " + req.getRequestURI());
		System.out.println("Method Name: " + req.getMethod());
		System.out.println("Remote Adds: " + req.getRemoteAddr());
		
		System.out.println("End Time" + LocalDateTime.now());
//		System.out.close();
		
		chain.doFilter(request, response);
	
	
	}

	public void init(FilterConfig fConfig) throws ServletException {

	
	}

}
