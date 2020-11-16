<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
	<form action="/join" method="POST">
		<fieldset>
			<legend>회원가입을 해주세요.</legend>
			<label>이메일주소</label><input type="text" id="email" name="email" /><br />
			<label>성명</label><input type="text" id="name" name="name" /><br />
			<label>비밀번호</label><input type="password" id="password" name="password" /><br />
			<label>비밀번호 확인</label><input type="password" id="password_confirm" name="password_confirm" /><br />
			<input type="submit" />
		</fieldset>
	</form>
	
</body>
</html>