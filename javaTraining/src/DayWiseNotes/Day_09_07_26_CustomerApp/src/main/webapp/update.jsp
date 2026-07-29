<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.coforge.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Update Customer</title>
</head>
<body>
	<h1>Update Customer</h1>

	<%
		Customer c = (Customer) request.getAttribute("customer");
	%>

	<form action="UpdateCustomerServlet" method="post">
	  <div class="mb-3">
	    <label class="form-label">Customer Id</label>
	    <input type="number" class="form-control" name="cid" value="<%=c.getCid()%>" readonly>
	  </div>

	  <div class="mb-3">
	    <label class="form-label">Customer Name</label>
	    <input type="text" class="form-control" name="cname" value="<%=c.getCname()%>">
	  </div>

	  <div class="mb-3">
	    <label class="form-label">Customer City</label>
	    <input type="text" class="form-control" name="city" value="<%=c.getCity()%>">
	  </div>

	  <button type="submit" class="btn btn-primary">Update</button>
	</form>
</body>
</html>