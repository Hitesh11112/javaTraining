package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2 = request.getSession(false);
		PrintWriter out = response.getWriter();
		String email = (String)session2.getAttribute("email");
		
		System.out.println(session2.getId());
		System.out.println(session2.getCreationTime());
		System.out.println(session2.getLastAccessedTime());
		
		if(session2 != null) {
			out.println("Thank You User with email: " + email);
			session2.invalidate();
		}else {
			response.sendRedirect("login.jsp");
		}
		
		response.setHeader("Cache-Control","no-cache no-store,must-revalidate"); // session is invalidated thats why we use this 
		response.setHeader("pragma","no-cache");
		response.setDateHeader("expires",0);
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
