<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<body>

	<table border="1" width="100%">
		<tbody>
			<tr height="50px;">
				<th width="10%">제목</th>
				<td colspan="2"></td>
			</tr>
			<tr height="300px;">
				<th>내용</th>
				<td width="60%" ></td>
				<td>여기는 사진</td>
			</tr>
		</tbody>
	</table>
	
	<p>&nbsp;</p><p>&nbsp;</p>
	<h1>댓글 작성</h1>
	<form id="">
		<label>홍길동</label><input type="text" id="contents" name="contents" style="width:50%;" />
		<input type="submit" value="보내기" id="btnSave" />
	</form>

	<p>&nbsp;</p><p>&nbsp;</p>
	<table border="1" width="100%">
		<tr>
			<td>홍길동</td>
			<td>안녕하세요</td>
			<td>2020.09.17</td>
			<td><button>삭제</button></td>
		</tr>
	</table>
	
	
	
</body>
</html>