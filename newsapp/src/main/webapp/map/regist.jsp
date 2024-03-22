<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//클라이언트가 비동기 요청을 시도한다는 것은, 현재 클라이언트가 보고 있는 페이지를 새로고침 하기를
	//원하지 않는다는 것이다. 따라서 서버에서는 완전한 html문서로 응답을 해서는 안됌!!
	//순수 데이터만을 보내주자 
	//현재 jsp의 경우, 글쓰기 역할을 수행해야 하므로, 등록 성공, 또는 실패 여부만을 보내주면 된다..
	
	request.setCharacterEncoding("utf-8");//파라미터가 깨지지 않도록...
	
	String lati=request.getParameter("lati");
	String longi=request.getParameter("longi");
	String name=request.getParameter("name");
	
	out.print("lati="+lati+", longi="+longi+", name="+name);
	
%>




