<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<body>
	<h1>상품 등록해주세요.</h1>
	
	<form id="" encType="multipart/form-data">
		<p><label>상품명</label><input type="text" id="goodsName" name="goodsName" /></p>
		<p>내용<textarea id="contents" name="contents"></textarea></p>
		<p><input type="file" id="file" name="file" /></p>
		<input type="submit" value="등록" id="btnJoin" />
	</form>
	
</body>
</html>