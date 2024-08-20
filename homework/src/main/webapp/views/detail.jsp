<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	location.href = "/guest/del?id=${guest.id }";
}
</script>
</head>
<body>

<h3>방명록 페이지</h3>
<form action="/guest/edit" method="post">
id: <input type="text" name="id" value="${guest.id }" readonly> <br/> 
writer: ${guest.writer } <br/> 
pwd: ${guest.pwd } <br/> 
wdate: ${guest.wdate } <br/> 
content : <input type="text" name="content " value="${guest.content }"><br/> 
<input type="submit" value="수정">
<input type="button" value="삭제" onclick="a()">
</form>
</body>
</html>