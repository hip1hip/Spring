<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h3>글목록</h3>
	<table border="1">
	<tr>
		<th> id</th>
		<th> writer</th>
		<th> pwd</th>
		<th> wdate</th>
		<th>content </th>
	</tr>
	<c:forEach var="c" items="${list }">
	<tr>
		<td> <a href="/detail?id=${c.id }">${c.id }</a></td>
		<td> ${c.writer }</td>
		<td> ${c.pwd }</td>
		<td> ${c.wdate }</td>
		<td> ${c.content  }</td>
	</tr>
	</c:forEach>
	</table>
	
	

</body>
</html>