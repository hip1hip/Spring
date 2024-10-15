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
<h3>방명록</h3>
<a href="/book/add">글작성</a><br/>
<c:if test="${list.size()==0 }">
  작성된 글이 없다
</c:if>

<c:if test="${list.size()!=0 }">
  <table border="1">
  	<tr><th>글번호</th><th>작성자</th></tr>
  	<c:forEach var="g" items="${list }">
  		<tr>
  			<td><a href="/book/detail?num=${g.num }">${g.num }</a></td>
  			<td>${g.writer }</td>
  		</tr>
  	</c:forEach>
  </table>
</c:if>
</body>
</html>