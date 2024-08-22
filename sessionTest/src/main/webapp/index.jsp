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
	<c:if test="${sessionScope.loginId == null }">
	<%-- ${msg }<br/> --%>
		<a href="/member/join">회원가입</a> <br>
		<a href="/member/login">로그인</a>
	</c:if>
	<c:if test="${sessionScope.loginId !=null }">
		${sessionScope.loginId }님의 타입은 ${sessionScope.type }입니다. <br/>
		<a href="/member/logout">로그아웃</a><br/>
		<a href="/member/info?id=${sessionScope.loginId }">내정보 확인</a><br/>
		<a href="">탈퇴</a><br/>
		<a href="">게시판</a><br/>
	
	</c:if>
	<!-- 내정보 보여주고 수정 가능하게 / 이름 이메일 타입  -->
</body>
</html>