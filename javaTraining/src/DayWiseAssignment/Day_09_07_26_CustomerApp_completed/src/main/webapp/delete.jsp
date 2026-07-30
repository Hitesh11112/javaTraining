<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.coforge.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Delete Customer</title>
</head>
<body class="p-4">
	<h1>Delete Customer</h1>

	<%
		Customer c = (Customer) request.getAttribute("customer");
	%>

	<div class="alert alert-danger">
		Are you sure you want to delete this customer? This action cannot be undone.
	</div>

	<table class="table table-bordered w-50">
		<tr>
			<th>Customer Id</th>
			<td><%=c.getCid()%></td>
		</tr>
		<tr>
			<th>Customer Name</th>
			<td><%=c.getCname()%></td>
		</tr>
		<tr>
			<th>City</th>
			<td><%=c.getCity()%></td>
		</tr>
	</table>

	<form action="DeleteCustomerServlet" method="post">
		<input type="hidden" name="cid" value="<%=c.getCid()%>">
		<button type="submit" class="btn btn-danger">Yes, Delete</button>
		<a class="btn btn-secondary" href="CustomerDetailsServlet">Cancel</a>
	</form>
</body>
</html>
