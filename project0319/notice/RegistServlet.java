package com.sds.project0319.notice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;

//글쓰기 요청을 처리하는 서블릿 클래스 정의
public class  RegistServlet extends HttpServlet{
	
	//글쓰기 요청은 post 방식으로 전송되므로, 서블릿 부모가 가진 메서드인 doXXXX형 
	// 중 doPost() 로 처리하자
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//<%@ page contentType="text/html;charset=utf-8"%>
		response.setContentType("text/html;charset=utf-8"); //단축식으로 표현도 가능
		//response.setCharacterEncoding("utf-8");

		//클라이언트가 전송한 파라미터 3개 받기 (한글깨지지 않게 )
		request.setCharacterEncoding("utf-8");

		//파라미터 받기 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		PrintWriter out =response.getWriter(); //응답 객체가 보유한 출력스트림 꺼내기 
		out.print("당신이 전송한 제목은 "+title+"<br>");
	}

}
