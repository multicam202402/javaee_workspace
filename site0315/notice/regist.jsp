<%@ page contentType="text/html;charset=utf-8"%>
<%
	/*
	클라이언트 측에서 전송한 제목, 작성자, 내용을 네트워크로 전송 받아서, 
	오라클에 대신 넣어주자 
	클라이언트가 요청을 시도할때, 서버측에서는 해당 요청을 처리하기 위해 무조건 생성되는 
	내장객체 2개가 있다.
	1) request  객체 : 클라이언트의 요청 정보가 들어있슴..(특히 전송된 데이터를 추출할때 유용)
	2) response 객체 : 클라이언트에게 응답할 정보를 가진 객체 (추후 응답시 html 재구성할때)
	*/
	
	//클라이언트가 전송한 데이터 받기 (파라미터(변수) 값 받기 )
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");

	//서버에 제대로 도착했는지 체크해본다
	out.print("전송된 제목은 "+title+"<br>");
	out.print("전송된 작성자는 "+writer+"<br>");
	out.print("전송된 내용은 "+content+"<br>");

%>