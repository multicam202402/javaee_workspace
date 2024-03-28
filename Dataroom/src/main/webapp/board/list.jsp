<%@ page contentType="text/html;charset=UTF-8"%>
<%
	int totalRecord=926; //총 레코드 수
	int pageSize=10; //한 페이지당 보여질 레코드 수 
	int totalPage= (int)Math.ceil((float)totalRecord/pageSize);
	int blockSize=10; //블럭당 보여질 페이지 수 
	int currentPage=1; //현재 유저가 보는 페이지 
	
	//유저가 페이지 번호를 선택할 경우, 1이 아닌 유저가 전송한 파라미터로 대체하자
	if(request.getParameter("currentPage") !=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
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
					<th>첨부파일</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=1;i<=pageSize;i++){ %>
				<tr>
					<td>John</td>
					<td>Doe</td>
					<td>john@example.com</td>
					<td>john@example.com</td>
					<td>john@example.com</td>
					<td>월말결산.xlsx</td>
				</tr>
				<%} %>
				<tr>
					<td colspan="6" align="center">
						<ul class="pagination">
						  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
						  <%for(int i=1;i<=blockSize;i++){%>
						  	<li class="page-item active"><a class="page-link" href="/board/list.jsp?currentPage=<%=i%>"><%=i%></a></li>
						  <%} %>
						  <li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>		
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>
