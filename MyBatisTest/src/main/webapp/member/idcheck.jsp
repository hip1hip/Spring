<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = () => {
		if('${msg }' == ''){
		f.id.value = opener.document.f.id.value;
					/* opener 이전 join에서 부른걸로 name f 의 id 를 찾음 */
		}else {
			if(${flag}){
				let div = document.getElementById("div");
				let html = "<input type = 'button' value = '아이디 사용' onclick= 'b()'>";
				div.innerHTML = html;
			}
		}
	}
	const b = () => {
		 opener.document.f.id.value = '${resultid}';
	}
</script>

</head>
<body>
	<h3>중복체크</h3>
	${msg }
	<form action="/member/idcheck" method="post" name="f">
		id: <input type="text" name="id" value="${resultid }"> 
			<input type="submit" value="중복체크">
	
	
	</form>
	<div id="div">
	
	</div>

</body>
</html>