<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>도시 추가 </h3>
	
	<form action="/index" method="get">
	Name: <input type="text" name="name"> <br/>
	CountryCode: <input type="text" name="countrycode"> <br/>
	District: <input type="text" name="district"> <br/>
	Population: <input type="number" name="population"> <br/>
	<input type="submit" value="추가">

</body>
</html>