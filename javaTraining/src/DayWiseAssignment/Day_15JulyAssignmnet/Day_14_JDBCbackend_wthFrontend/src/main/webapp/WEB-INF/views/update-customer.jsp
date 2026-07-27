<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Update Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Update Customer</h2>

<form action="../modify" method="post">
	<div class="mb-3">
		<label>Customer ID</label>
		<input type="number" name="cId" class="form-control" value="${customer.cId}" readonly>
	</div>
	<div class="mb-3">
		<label>Name</label>
		<input type="text" name="cName" class="form-control" value="${customer.cName}">
	</div>
	<div class="mb-3">
		<label>City</label>
		<input type="text" name="city" class="form-control" value="${customer.city}">
	</div>
	<button type="submit" class="btn btn-primary">Update</button>
	<a href="../../customers-ui" class="btn btn-secondary">Cancel</a>
</form>

</body>
</html>