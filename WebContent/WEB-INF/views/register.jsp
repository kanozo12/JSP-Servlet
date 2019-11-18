<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./layout/msgdiv.jsp"></jsp:include>
	<h2>회원가입</h2>
	<p>회원가입 하세요</p>
	<form action="/register" method="POST">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" placeholder="아이디를 입력하세요">
		</div>
		<div class="form-group">
			<label for="name">이름</label>
			<input type="text" name="name" id="name" placeholder="이름을 입력하세요">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요">
		</div>
		<button type="submit">회원가입</button>	
	</form>
</body>
</html>