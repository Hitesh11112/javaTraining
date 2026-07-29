<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  HttpSession session1 = request.getSession(false); 
		String email = null;
		if(session1 != null) {
			email=(String) session1.getAttribute("email");	
			System.out.println(session1.getId());
			out.println("Welcome User with email: " + email);
		
	%>	
	<a href="LogoutServlet">Logout</a>
	<%
		} else{ 
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>