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
	<h3>글 추가</h3>
	<form action="/add" method="post">
	글번호: <input type="number" name="id" readonly> <br/>
	작성자: <input type="text" name="writer"  > <br/>
	글비밀번호: <input type="text" name="pwd"  > <br/>
	작성일: <input type="date" name="wdate" readonly> <br/>
	내용: <input type="text" name="varchar"  > <br/>
	
	<input type="submit" value="추가">
	
	</form>
	
	

</body>
</html>