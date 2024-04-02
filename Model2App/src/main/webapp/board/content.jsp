<%@page import="com.sds.model2app.domain.Board"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//컨트롤러에서 심어놓은 결과 가져오기 
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/inc/header.jsp" %>
<script type="text/javascript">

//폼의 입력 데이터들을 서버로 전송하자 
function regist(){
	$("form").attr({
		action:"/board/regist.do", 
		method:"post"
	});
	$("form").submit(); //전송
}

$(document).ready(function() {
	
	$("textarea").summernote({
		height:300, 
		placeholder:"내용 입력.."
	}); //textarea를 편집기로 변신!!
	
	//수정 버튼에 이벤트 연결 
	$("#bt_edit").click(function(){
		edit();
	});
	//삭제 버튼에 이벤트 연결 
	$("#bt_del").click(function(){
		del();
	});
	//목록 버튼에 이벤트 연결 
	$("#bt_list").click(function(){
		location.href="/board/list.do";
	});
	
});
</script>
</head>
<body>
<h2>글쓰기 폼</h2>
	<form>
	    <div class="form-group">
	        <input type="text" class="form-control" value="<%=board.getTitle() %>" name="title">
	    </div>
	    <div class="form-group">
	        <input type="text" class="form-control" value="<%=board.getWriter() %>" name="writer">
	    </div>
	    <div class="form-group">
	        <textarea class="form-control" name="content"><%=board.getContent() %></textarea>
	    </div>

	    <button type="button" class="btn btn-primary" id="bt_edit">수정</button>
	    <button type="button" class="btn btn-primary" id="bt_del">삭제</button>
	    <button type="button" class="btn btn-primary" id="bt_list">목록</button>
	</form>
</body>
</html>