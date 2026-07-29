<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.coforge.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h1>Customers Details</h1>
	

	<a class="btn btn-primary" href="add.jsp">Add</a>
	
	<table  class="table table-striped">
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>City</th>
			<th>Actions</th>
		</tr>
		<%
			ArrayList<Customer> customerList=(ArrayList<Customer>)request.getAttribute("customerList");
			
			if (customerList == null) {
		        customerList = new ArrayList<Customer>();
		    }
		
			for(Customer c:customerList){
		%>
		<tr>
		
			<td><%=c.getCid() %></td>
			<td><%=c.getCname() %></td>
			<td><%=c.getCity() %></td>
			<td>
				<!-- <a class="btn btn-success" href="update.jsp">Update</a> -->
				<a class="btn btn-success" href="UpdateCustomerServlet?cid=<%=c.getCid()%>">Update</a>
				<a class="btn btn-danger" href="delete.jsp">Delete</a>
			</td>
		</tr>
		<% 	}%>
	
	</table>
	
</body>
</html>