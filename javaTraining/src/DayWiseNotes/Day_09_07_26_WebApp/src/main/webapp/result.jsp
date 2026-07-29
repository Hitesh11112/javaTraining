<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
int a = Integer.parseInt(request.getParameter("firstnum"));
int b = Integer.parseInt(request.getParameter("secondnum"));
String s = request.getParameter("op");

int result = 0;

if(s.equals("+"))
    result = a+b;
else if(s.equals("-"))
    result = a-b;
else if(s.equals("*"))
    result = a*b;
else if(s.equals("/"))
    result = a/b;
%>
<div class="container mt-5 text-center">
    <div class="card shadow p-4 mx-auto" style="width:350px;">
        <h3 class="text-primary">Result</h3>
        <h5><%=a%> <%=s%> <%=b%> = </h5><h2 class="text-success"><%=result%></h2>
        <a href="index.jsp" class="btn btn-primary">Back</a>
    </div>

</div>

</body>
</html>