<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<body>
	<form action="/goods/write" method="POST" encType="multipart/form-data">
		<fieldset>
			<legend>상품 등록해주세요.</legend>
			<label>상품명</label><input type="text" id="goodsName" name="goodsName" /><br />
			<label>내 용</label><textarea id="contents" name="contents"></textarea><br />
			<input type="file" id="filename" name="filename" /><br />
			<input type="submit" value="등록" id="btnJoin" />
		</fieldset>
	</form>
	
</body>
</html>