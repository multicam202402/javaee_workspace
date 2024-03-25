package com.sds.poolproject.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 글쓰기 요청을 처리하는 서블릿
public class RegistServlet extends HttpServlet{
	
	//클라이언트가 post 방식으로 전송을 시도하기 때문에, doPost 재정의한다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트의 파라미터 받기 
		request.setCharacterEncoding("utf-8"); 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("제목은 "+title);
		System.out.println("작성자는 "+writer);
		System.out.println("내용은 "+content);
	}

}







