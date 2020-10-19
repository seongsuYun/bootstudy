<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin-bottom:50px; text-align:right;">
	<span><label>${sessionScope.USER_SESSION.name}</label>님, 환영합니다.</span>
	<button>로그아웃</button>
	<button>관리자모드</button>
</div>