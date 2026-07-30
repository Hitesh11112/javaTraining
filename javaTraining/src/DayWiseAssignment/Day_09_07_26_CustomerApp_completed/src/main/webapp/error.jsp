<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Error</title>
</head>
<body class="p-4">

	<h1 class="text-danger">Oops! Something went wrong</h1>

	<%
		// A custom message set by our own servlets via request.setAttribute("errorMessage", ...)
		String customMessage = (String) request.getAttribute("errorMessage");

		// The container-level exception (present when this page is used as web.xml's error-page,
		// or when a servlet forwards here with request.setAttribute("exception", e))
		Throwable containerException = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
		Throwable customException = (Throwable) request.getAttribute("exception");
		Throwable t = (containerException != null) ? containerException : customException;
	%>

	<% if (customMessage != null) { %>
		<div class="alert alert-warning"><%= customMessage %></div>
	<% } else { %>
		<div class="alert alert-warning">An unexpected error occurred while processing your request.</div>
	<% } %>

	<% if (t != null) { %>
		<div class="alert alert-secondary">
			<strong>Details:</strong> <%= t.toString() %>
		</div>
	<% } %>

	<a class="btn btn-primary" href="<%=request.getContextPath()%>/CustomerDetailsServlet">Back to Customer List</a>
	<a class="btn btn-secondary" href="<%=request.getContextPath()%>/index.jsp">Home</a>

</body>
</html>
