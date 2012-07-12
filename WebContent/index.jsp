<%request.getSession(false); %>
<html>
	<head>
		<title>
			Welcome <%=session.getAttribute("username") %>
		</title>
	</head>
<body>
	<form action="oauth" method="post">
		<a href="LocalUrl">URL to Tweet</a> <input type="submit"
			value="Tweet This">
	</form>

	<form action="getRetweetCount" method="post">
		<input type="submit" value="Get Total Count">
	</form>
	
	<a href="search.jsp">Search</a>
</body>
</html>