<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp" %>
<%@include file="../include/session_check.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnSave").click(function() {
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
			
/* 			if(writer==""){
				alert("작성자를 입력하세요");
				document.form1.writer.focus();
				return;
			} */
			
			//폼에 입력한 데이터를 서버로 전송함
			document.form1.submit();

		});
	});
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시물 작성</h2>
<form name="form1" method="post" action="${path }/board/insert.do">
	<div>
		제목
		<input name="title" placeholder="제목을 입력하세요" size="80">
	</div>
	
	<div>
		내용
		<textarea name="content" rows="3" cols="80"
		placeholder="내용을 입력하세요"  ></textarea>
	</div>
	
<!-- 	<div>
		이름
		<input name="writer" placeholder="이름을 입력하세요">
	</div> -->
	<div style="width: 700px; text-align: center;">
		<button type="button" id="btnSave">확인</button>
	</div>
</form>
</body>
</html>