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
						
	
	</div>

</body>
</html>
