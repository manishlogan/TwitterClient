<%request.getSession(false); %>

<html>
	<head>
		<title>Total Count</title>
	</head>
	
	<body>
		Total Count is : <%=request.getAttribute("count") %>
	</body>
</html>