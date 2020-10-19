<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<body>

	<table border="1px" width="100%">
		<thead>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.GOODS_SEQ}</td>
				<td>${item.IMG_SEQ}</td>
				<td>${item.GOODS_NAME}</td>
				<td>${item.NAME}</td>
				<td>${item.ENTER_DATE}</td>
				<td>3</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form id="">
		<p><input type="text" id="keyword" name="keyword" /></p>
		<input type="submit" value="검색" id="btnSearch" />
	</form>
	
</body>
</html>