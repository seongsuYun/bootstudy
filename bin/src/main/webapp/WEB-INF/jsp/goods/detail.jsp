<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function() {
	loadCommentList();
	
	$("#btnSave").on("click", function() {
		$.ajax({
            url:'/goods/addGoodsComment',
            type:'post',
            data:{
                contents:$('#contents').val(),
                goodsSeq:${param.goodsSeq}
            },
            success:function(data){
            	$('#contents').val('');
            	loadCommentList();
            }
        })
	});
	
});

function loadCommentList() {
	$("#commentWrapper").load("/goods/commentList?goodsSeq=${param.goodsSeq}");
}

function deleteGoodsComment(commentSeq) {
	$.ajax({
        url:'/goods/deleteGoodsComment',
        type:'get',
        data:{commentSeq:commentSeq},
        success:function(data){
        	loadCommentList();
        }
    })
}
</script>
</head>
<body>

	<table border="1" width="100%">
		<tbody>
			<tr height="50px;">
				<th width="10%">제목</th>
				<td colspan="2">${goodsDetail.GOODS_NAME}</td>
			</tr>
			<tr height="300px;">
				<th>내용</th>
				<td width="60%" >${goodsDetail.CONTENTS}</td>
				<td><img src="${pageContext.request.contextPath}/upload/${goodsDetail.IMG_NAME}" /></td>
			</tr>
		</tbody>
	</table>
	
	<p>&nbsp;</p><p>&nbsp;</p>
	<h1>댓글 작성</h1>
	<label>홍길동</label><input type="text" id="contents" name="contents" style="width:50%;" />
	<input type="button" value="보내기" id="btnSave" />

	<p>&nbsp;</p><p>&nbsp;</p>
	<div id="commentWrapper"></div>
	
	<p>&nbsp;</p><p>&nbsp;</p>
	<button><a href="/goods/list">목록보기</a></button>
	
</body>
</html>