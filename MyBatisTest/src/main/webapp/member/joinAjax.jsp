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
		// 비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		//비동기 요청에 대한 응답이 오면 자동 호출될 핸들러 등록 
		//받은 응답은 비동기 객제의 responseText 속성에 저장됨 
		// res: {flag:true}
		req.onload = () => {
				let res = document.getElementById("res");
				let msg = '중복된 아이디'
				let obj = JSON.parse(req.responseText);
				if(obj.flag){
					msg = '사용가능한 아이디'
				}
				res.innerHTML = msg;
		}
		
		// 전송할 파라미터 정의 
		let params = 'id='+document.getElementById("id").value;
		
		//open() 로 요청 설장 
		req.open('get', '/member/idcheckAjax?' + params);
		
		//요청 전송 
		req.send();
	}


</script>
<body>
	<h3> ID </h3>

	<form action="/member/join" method="post" name="f">
		<table border="1">
		<tr>
			<th> ID </th>
			<td> 
				<input type="text" name="id" id="id"> 
				<input type="button" value="중복체크" onclick="a()"><div id = "res"></div> 
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