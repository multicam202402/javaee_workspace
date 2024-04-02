<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/inc/header.jsp"%>
</head>
<body>
	<h2>Hoverable Dark Table</h2>
	<p>The .table-hover class adds a hover effect (grey background
		color) on table rows:</p>
		
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=1;i<=10;i++){ %>
			<tr>
				<td>1</td>
				<td>제목나올 곳</td>
				<td>배트맨</td>
				<td>2024-04-02</td>
				<td>205</td>
			</tr>
			<%} %>
			<tr>
				<td colspan="5">
					<button class="btn-primary">글등록</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>




