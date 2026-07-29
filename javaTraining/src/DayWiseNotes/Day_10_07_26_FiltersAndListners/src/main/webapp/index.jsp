<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>

<h2><%= "Hello World!" %></h2>

<form action="LoginServlet">
			
	<label for="uname" class="form-label"> UserName: </label>
	<input type="text" class="form-control" name="uname" id="uname">
	
	<label for="pwd" class="form-label"> Password: </label>
	<input type="password" class="form-control" name="pwd" id="pwd">
	
	<button class="btn btn-primary">Login</button>

</form>
</body>
</html>
