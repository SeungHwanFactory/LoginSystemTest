<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>가입</title>
</head>
<body>
<h1>회원 가입 페이지</h1>
<form action="/user/register" method="post">
	<div>
		<input type="text" name="userId" placeholder="아이디">
	</div>
	<div>
		<input type="text" name="userName" placeholder="이름">
	</div>
	<div>
		<input type="email" name="userEmail" placeholder="이메일">
	</div>
	<div>
		<input type="password" name="userPw" placeholder="비밀번호">
	</div>
	<div>
		<input type="password" placeholder="비밀번호 확인">
	</div>
	<div>
		<button type="submit">가입</button>
	</div>


</form>

</body>
</html>
