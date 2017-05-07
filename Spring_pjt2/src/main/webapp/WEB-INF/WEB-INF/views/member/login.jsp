<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp" %>
<script>
$(document).ready(function() {
	$("#btnLogin").click(function() {
		var userid=$("#userid").val();
		var userpw=$("#userpw").val();
		
		if(userid==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return;
		}
		
		if(userpw==""){
			alert("비밀번호를 입력하세요");
			$("#userpw").focus();
			return;
		}
		
		document.form1.action="${path}/member/login_check.do";
		document.form1.submit();
	});			
});
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>로그인</h2>
<form name="form1" method="post">
<table border="1" width="400px">
	<tr>
		<td>아이디</td>
		<td><input type="text" id="userid" name="userid"></td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><input type="password" id="userpw" name="userpw"></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<button type="button" id="btnLogin">로그인</button>
			<c:if test="${message eq'error' }">
				<div style="color: red;">아이디 또는 비밀번호가 일치 하지 않습니다.</div>
			</c:if>
			
			<c:if test="${message eq'logout' }">
				<div style="color: red;">로그 아웃이 되었습니다.</div>
			</c:if>
			
		</td>
	</tr>
	
	
</table>
</form>
</body>
</html>