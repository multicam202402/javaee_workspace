<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/inc/header_link.jsp" %>

</head>
<body>

<div class="row">
	<div class="col-12">
	
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">Horizontal Form</h3>
			</div>
		
		<form class="form-horizontal">
		<div class="card-body">
		
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3" placeholder="제목 입력">
			</div>
		</div>
		
		<div class="form-group row">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
			<input type="text" class="form-control" id="inputPassword3" placeholder="작성자입력">
		</div>
		
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<textarea class="form-control" placeholder="제목 입력"> </textarea>
			</div>
		</div>
		</div>
	
		</div>
		
		<div class="card-footer">
			<button type="button" class="btn btn-info" id="bt_regist">글쓰기</button>
			<button type="button" class="btn btn-default float-right" id="bt_list">목록</button>
		</div>
		
		</form>
		</div>	
	
	</div>
</div>

</body>
</html>