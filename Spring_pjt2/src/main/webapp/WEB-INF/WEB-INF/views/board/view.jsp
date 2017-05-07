<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnUpdate").click(function() {
// 			var writer=document.form1.writer.value;
			var content=document.form1.content.value;
			var title =document.form1.title.value;
			
			/* var write=$("#writer").val();
			var write=$("#content").val();
			var write=$("#title").val(); */
			
			
			if(title==""){
				alert("제목을 입력하세요");
				document.form1.title.focus();
				return;
			}
			
			if(content==""){
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			
// 			if(writer==""){
// 				alert("작성자를 입력하세요");
// 				document.form1.writer.focus();
// 				return;
// 			} 
			//수정 주소
			document.form1.action="${path}/board/update.do";
			//폼에 입력한 데이터를 서버로 전송함
			document.form1.submit();

		});
		
		
	});
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시물 작성</h2>
<form name="form1" method="post">
	<div>
		작성일자 : <fmt:formatDate value="${dto.regdate }" pattern="yyyy-mm-dd hh:mm:ss"></fmt:formatDate>
	</div>
	
	<div>
		조회수 : ${dto.viewcnt }
	</div>
	<div>
		제목
		<input name="title"  value="${dto.title }" placeholder="제목을 입력하세요" size="80">
	</div>
	
	<div>
		내용
		<textarea name="content" rows="3" cols="80"
		placeholder="내용을 입력하세요"  >${dto.content }</textarea>
	</div>
	
	<div>
		이름 : ${dto.username }
	</div>
	<div style="width: 700px; text-align: center;">
	<input type="hidden" name="bno" value="${dto.bno}">
	<c:if test="${sessionScope.userid == dto.writer }">
		<button type="button" id="btnUpdate">수정</button>
		<button type="button" id="btnDelete">삭제</button>
	</c:if>
	</div>
</form>
</body>
</html>