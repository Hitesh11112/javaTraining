package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FirstServlet() {
    
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<h1>First Servlet</h1>");
		
		String name=request.getParameter("name");
		System.out.println(name);
		
		request.setAttribute("name", name);
		
		Cookie cookie = new Cookie("username", name);
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		
//		out.println("<form action=SecondServlet><button>Move To Second Servlet</button></form>");
		
		
		//2. URL re writing 
//	    out.println("<form action='SecondServlet?username=" + name + " '><button>Move To Second Servlet</button></form>");
//		out.println("<a href='SecondServlet?username=" + name + "'>Move To Second Servlet</a>");
//		out.println("<form action=SecondServlet?username=" + name + "'><button>Move To Second Servlet</button></form>");
		
		out.println("<form action='SecondServlet' method='get'>");
	    out.println("<input type='text' name='username' value='" + name + "'>");
	    out.println("<button>Move To Second Servlet</button>");
	    out.println("</form>");
	    
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);

	}

}
