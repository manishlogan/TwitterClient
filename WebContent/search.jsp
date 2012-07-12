<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
	<form action="search" method="post">
		<input type="text" name="searchText" id="searchText" /> <input
			type="submit" value="Search">
	</form>

	<c:if test="${searchData != null}">
		<table>
			<tr>
				<th>User</th>
				<th>Tweet</th>
			</tr>
			<c:forEach items="${searchData}" var="currentItem">
				<tr>
					<td>${currentItem.key}</td>
					<td>${currentItem.value }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>