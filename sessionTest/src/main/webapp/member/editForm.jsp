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
		<table border="1">
		<tr>
			<th> 아이디 : </th>
			<td> <input type="text" name="id" value="${member.id}" readonly></td>
			
		</tr>
		<tr>	
			<th> 이름 : </th>
			<td> <input type="text" name="name">  </td>
		</tr>	
		<tr>
			<th> 이메일 : </th>
			<td>  <input type="text" name="email"></td>
		</tr>		
		<tr>
			<th> 타입 : ${member.type }  </th>
			<td> 
				<select name="type">
					<option value=""> --선택-- </option>
					<option value="판매자" > 판매자 </option>
					<option value="구매자" > 구매자 </option>
				</select>
			</td>
		</tr>	
		<tr>
			<th>   </th>
			<td> <button type="submit" > 완료 </button> </td>
		</tr>			
		

		</table>
	</form>
</body>
</html>