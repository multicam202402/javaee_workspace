<%@ page contentType="text/html;charset=utf-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
      table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
      }

      th,
      td {
        text-align: left;
        padding: 16px;
      }

      tr:nth-child(even) {
        background-color: #f2f2f2;
      }
    </style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
			
		//js에서의 addEventListener("load", function(){}); 동일
		$(function(){  
			//문서내의 버튼에 클릭 이벤트 연결 
			//JQuery의 형식  (주체-css선택자).어떻게()
			$("button").click(function(){
				//톰켓이 보유한 글쓰기 jsp를 요청하자!!
				location.href="/notice/write.jsp";
			});
			
		});
	</script>

  </head>

  <body>

    <h2>공지게시판</h2>

  <table>
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
      
      <%for(int i=1;i<=10;i++){%>
      <tr>
        <td>Jill</td>
        <td>Smith</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
      </tr>
      <%}%>
		<tr>
			<td colspan="5">
				<button>글쓰기</button>
			</td>	
		</tr>

  </table>

  </body>

  </html>