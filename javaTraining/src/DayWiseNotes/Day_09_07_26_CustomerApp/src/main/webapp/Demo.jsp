<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<% PrintWriter pw= response.getWriter(); %>
	<% out.println("This is jsp page using scriptlet");%>  <!-- this is  jsp scriptlets -->
	<br>
	
	<%!int a = 6, b = 8; %>  <!-- this is  jsp declerations -->
	<%= a+b %> <!-- this is  jsp expressions ---->
	
	<%!Integer arr[]={1,2,3,4,5,6}; %>
	<%List<Integer> alist=Arrays.asList(arr); %>
	
	<%pw.println(alist); %>
	
	<%for(Integer i = 0; i < arr.length;i++) {
		pw.println(i);
	}
		
		
	%>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</html>