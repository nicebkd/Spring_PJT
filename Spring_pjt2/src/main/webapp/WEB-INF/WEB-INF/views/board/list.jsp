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
		$("#btnWrite").click(function() {
			//페이지 주소 변경 이동
			location.href="${path}/board/write.do";
		});
	});
	
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시판</h2>
<form name="form1" method="post" action="${path }/board/list.do" >
<select name="search_option">
	<option value="all"
	<c:out
	value="${map.search_option=='all'?'selected':''}"/>>이름+내용+제목</option>
	<option value="username"
	<c:out
	value="${map.search_option=='username'?'selected':''}"/>>이름</option>
	<option value="content"
	<c:out
	value="${map.search_option=='content'?'selected':''}"/>>내용</option>
	<option value="title" 
	<c:out
	value="${map.search_option=='title'?'selected':''}"/>>제목</option>
</select>
<input name="keyword" value="${map.keyword }">
<input type="submit" value="조회">
<c:if test="${sessionScope.userid != null }">
<button type="button" id="btnWrite">글쓰기</button>
</c:if>
</form>
${map.count }개의 게시물이 있습니다.
<table border="1" width="600px">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>이름</td>
		<td>날짜</td>
		<td>조회수</td>		
	</tr> 
	<c:forEach var="row" items="${map.list }">
		<tr>
			<td>${row.bno }</td>
			<td>
			<a href="${path }/board/view.do?bno=${row.bno}">${row.title }</a></td>
			<td>${row.username }</td>
			<td>
			<fmt:formatDate value="${row.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${row.viewcnt }</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>