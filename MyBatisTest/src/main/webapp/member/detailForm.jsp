<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상세 정보</h3>
	아이디 : ${member.id } <br/>
	이름 : ${member.name} <br/>
	이메일 : ${member.email } <br/>
	타입 : ${member.type } <br/>
	<button type="button" onclick="location.href='/member/edit?id=${member.id}'"> 수정 </button>
	
</body>
</html>