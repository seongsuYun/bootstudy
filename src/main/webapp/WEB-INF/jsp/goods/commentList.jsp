<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table border="1" width="100%">
		<c:forEach var="item" items="${commentList}">
		<tr>
			<td>${item.NAME}</td>
			<td>${item.CONTENTS}</td>
			<td>${item.ENTER_DATE}</td>
			<td><button><a onClick="javascript:deleteGoodsComment('${item.COMMENT_SEQ}');">삭제</a></button></td>
		</tr>
		</c:forEach>
	</table>