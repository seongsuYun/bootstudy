<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
	<h1></h1>
	
	<form action="/login" method="POST">
		<fieldset>
			<legend>로그인 페이지</legend>
			<label>이 메 일</label><input type="text" id="email" name="email" placeholder="이메일주소" /><br />
			<label>패스워드</label><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" /><br />
			<input type="submit" />
		</fieldset>
	</form>
	<div style="float:right;">
		<button><a href="/join">회원가입</a></button>
	</div>
</body>
</html>