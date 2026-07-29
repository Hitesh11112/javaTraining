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
	<h1>Add</h1>
	
	<form action="AddCustomerServlet">
	  <div class="mb-3">
	    <label for="cid" class="form-label">Customer Id</label>
	    <input type="number" class="form-control" id="cid" name="cid">
	  </div>
	  
	  <div class="mb-3">
	    <label for="cname" class="form-label">Customer Name</label>
	    <input type="text" class="form-control" id="cname" name="cname">
	  </div>
	  
	  <div class="mb-3">
	    <label for="city" class="form-label">Customer City</label>
	    <input type="text" class="form-control" id="city" name="city">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</html>