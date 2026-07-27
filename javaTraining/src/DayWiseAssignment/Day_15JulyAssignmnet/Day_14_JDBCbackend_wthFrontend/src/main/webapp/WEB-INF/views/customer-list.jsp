<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Customer List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Customer List</h2>
<a href="customers-ui/add" class="btn btn-primary mb-3">Add Customer</a>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Customer ID</th>
			<th>Name</th>
			<th>City</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cust" items="${customerList}">
			<tr>
				<td>${cust.cId}</td>
				<td>${cust.cName}</td>
				<td>${cust.city}</td>
				<td>
					<a href="customers-ui/update/${cust.cId}" class="btn btn-sm btn-secondary">Edit</a>
					<a href="customers-ui/delete/${cust.cId}" class="btn btn-sm btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>