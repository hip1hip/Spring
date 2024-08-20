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
	<h3>도시 추가 </h3>
	
	<form action="/city/add" method="post">
	Name: <input type="text" name="name"> <br/>
	CountryCode: <select name="countryCode">
	<c:forEach var="code" items="${list }">
			<option value="${code }">${code } </option>
	 </c:forEach>
	

	 </select><br/>
	District: <input type="text" name="district"> <br/>
	Population: <input type="number" name="population"> <br/>
	<input type="submit" value="추가">
	</form >
</body>
</html>