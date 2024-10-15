<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
const a = () => {
	let pwd = prompt("글 비밀번호", "");
	if(pwd == '${gb.pwd}'){
		let cont = prompt("새 글내용", "");
		location.href = "/book/edit?num=${gb.num}&content="+cont;
	}else{
		alert('글 비밀번호 불일치');
	}
}
const b = () => {
	let pwd = prompt("글 비밀번호", "");
	if(pwd == '${gb.pwd}'){
		location.href = "/book/del?num=${gb.num}";
	}else{
		alert('글 비밀번호 불일치');
	}
}
</script>
<body>
	<h3>상세 페이지</h3>
	<table border="1">
	<tr><th>글번호</th><td>${gb.num }</td></tr>
	<tr><th>작성자 </th><td>${gb.writer }</td></tr>
	<tr><th>작성일 </th><td>${gb.wdate }</td></tr>
	<tr><th>내용 </th><td>${gb.content }</td></tr>
	<tr>
		<th>변경 </th>
		<td>
			<input type="button" value="수정" onclick="a()">
			<input type="button" value="삭제" onclick="b()">
		</td>
	</tr>
	</table>
</body>
</html>