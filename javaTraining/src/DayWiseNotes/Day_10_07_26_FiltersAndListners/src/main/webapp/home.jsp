<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 	HttpSession session1 = request.getSession(false); 
		String uname = null;
		if(session1 != null) {
			uname = (String) session1.getAttribute("uname");
			out.println("Welcome.... " + uname);
	%>
	<a class="btn btn-info" href="info.jsp">Info</a>
	<a class="btn btn-primary" href="LogoutServlet">Logout></a>
	<%
		} else {
			response.sendRedirect("index.jsp");
		}
	
	
	%>
</body>
</html>