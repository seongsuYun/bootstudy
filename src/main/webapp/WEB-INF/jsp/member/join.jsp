<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
	<h1>회원가입을 해주세요.</h1>
	
	<form>
		<p><label>이메일주소</label><input type="text" id="email" name="email" /></p>
		<p>성명<input type="text" id="name" name="name" /></p>
		<p>비밀번호<input type="password" id="password" name="password" /></p>
		<p>비밀번호 확인<input type="password" id="password_confirm" name="password_confirm" /></p>
		<input type="submit" value="회원가입" id="btnJoin" />
	</form>
	
</body>
</html>