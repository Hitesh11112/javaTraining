<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Accounts List</h1>
	<a href="accounts/add" class="btn btn-primary">Add</a>
	<table class="table table-striped">
		
		<tr>
			<th>AccountId</th>
			<th>AccountHolderName</th>
			<th>Balance</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${accountList}" var="acc">
			<tr>
				<td>${acc.accNo}</td>
				<td>${acc.accHolderName}</td>
				<td>${acc.balance}</td>
				<td>${acc.address}</td>
				<td>
					<a href="accounts/update/${acc.accNo}" class="btn btn-success">Update</a>
					<a href="accounts/delete/${acc.accNo}" class="btn btn-danger">Delete</a>
					<a href="accounts/info/${acc.accNo} " class="btn btn-info">Info</a>
				</td>
			</tr>
			
		</c:forEach>
		
	</table>
</body>
</html>