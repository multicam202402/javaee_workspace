package com.sds.sessionapp.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	//클라이언트가 전송한 데이터가, 비밀번호가 포함되어 있기 때문에 post방식으로 요청을 들어오므로, 
	//doXXX 형 중 doPost() 처리하자 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); //jsp의 page 지시영역에 해당 
		PrintWriter out = response.getWriter(); //html 문서를 구성하기 위한 출력스트림 
		
		//클라이언트가 전송한 파라미터 받기
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		System.out.println("아이디는 "+id);
		System.out.println("패스워드는 "+pass);
	}
}













