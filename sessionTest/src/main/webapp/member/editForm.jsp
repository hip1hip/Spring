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
	<form action="/member/edit" method="post">
		아이디 : ${member.id } <input type="hidden" name="id" value="${member.id}"><br/>
		이름 : <input type="text" name="name"> <br/>
		이메일 :  <input type="text" name="email"><br/>
		타입 : ${member.type } 
		<select name="type">
			<option value=""> --선택-- </option>
			<option value="판매자" > 판매자 </option>
			<option value="구매자" > 구매자 </option>
		</select>
		<br/>
		<button type="submit" > 완료 </button>
	
	</form>
</body>
</html>