<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	const a= () =>{
		let win = open("idcheck.jsp", "win", "width=300, height=300, top=100, left=100");
	}
</script>

</head>
<body>
	<h3>회원가입</h3>
	<form action="/member/join" method="post" name="f">
		<table border="1">
		<tr>
			<th> ID </th>
			<td> 
				<input type="text" name="id"> 
				<input type="button" name="중복체크" value="중복체크" onclick="a()"> 
			</td>
		</tr>
		<tr>
			<th> PWD </th>
			<td> <input type="password" name="pwd"> </td>
		</tr>			
		<tr>
			<th> name </th>
			<td> <input type="text" name="name"> </td>
		</tr>		
		<tr>
			<th> email </th>
			<td> <input type="email" name="email"> </td>
		</tr>		
		<tr>
			<th> type </th>
			<td> 
				<select name="type">
					<option>구매자 </option>
					<option>판매자</option>
				</select>
			</td>
		</tr>	
		<tr>
			<th> 회원가입완료  </th>
			<td> <input type="submit" name="화원가입"> </td>
		</tr>	
		</table>
	</form>
	
</body>
</html>