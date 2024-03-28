<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/inc/header_link.jsp" %>
<script type="text/javascript">
	$(function(){
			
		$("button").click(function(){
			location.href="/board/write.jsp";
		});
		
	});
</script>
</head>
<body>

	<div class="container">
		<h2>글쓰기 폼</h2>
		<!-- 입력 폼 시작  -->
		<form>
			<div class="form-group">
				<input type="text" class="form-control" name="title" placeholder="제목입력..">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="writer" placeholder="작성자..">
			</div>
			<div class="form-group">
				<textarea class="form-control" name="content" placeholder="작성자.."></textarea>
			</div>
			<div class="form-group">
				<input type="file" class="form-control" name="file">
			</div>
			
			<button type="button" class="btn btn-primary">Submit</button>
		</form>

	</div>

</body>
</html>
