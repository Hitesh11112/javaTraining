package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public WelcomeServlet() {

    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");		
//		out.println("---------Logs----------------");
//		out.println("<h1>Start Time" + LocalDateTime.now() + "</h1>");
//		
//		out.println("<br>URL " + request.getRequestURI());
//		out.println("<br>Method Name: " + request.getMethod());
//		out.println("<br>Remote Adds: " + request.getRemoteAddr());
//		
//		out.println("<h1>End Time" + LocalDateTime.now() + "</h1>");
	

		out.println("<h1>This is Welcome Servlet</h1>");
		out.close();

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		doGet(request, response);
	
	}
	

}
