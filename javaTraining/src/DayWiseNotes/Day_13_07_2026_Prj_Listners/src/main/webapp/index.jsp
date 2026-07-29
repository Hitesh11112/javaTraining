<html>
<body>
	<h1>Demo On ServletContextListner</h1>
	<form action="AppCountServlet">
		<button type="submit" >Visit App</button>
	</form>
	
	<%
	
		Object count = application.getAttribute("count");
		if(count != null) 
	%>
	
	<%-- <h3>Total Count : <%= count %></h3>
	 --%>
	<h3>Total Count : <%= application.getAttribute("count") %></h3>
</body>
</html>
