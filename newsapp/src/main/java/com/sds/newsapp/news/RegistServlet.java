package com.sds.newsapp.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{ //서버에서만 실행될 수 있도록 서블릿으로 정의한다
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//클라이언트가 전송한 파라미터 받기 
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		System.out.println("제목 "+title);
		System.out.println("작성자 "+writer);
		System.out.println("내용 "+content);
		
		
	}
}






