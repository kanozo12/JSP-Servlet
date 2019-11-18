<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./layout/msgdiv.jsp"></jsp:include>
	
	<h2>글쓰기 시스템</h2>
	<p>로그인 하세요</p>
	<form action="/" method="POST">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" placeholder="아이디를 입력하세요">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요">
		</div>
		<button type="submit">로그인</button>	
		<a href="/register">회원가입</a>
	</form>
</body>
</html>