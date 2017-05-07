<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<title>Home</title>
<%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/menu.jsp" %>
<h1>
<c:if test="${message =='success'}">
<h2>${sessionScope.username}(${sessionScope.userid })</h2>
</c:if>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
