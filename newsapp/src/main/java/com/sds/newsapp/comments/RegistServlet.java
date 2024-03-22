package com.sds.newsapp.comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 댓글 등록 요청을 처리하는 서블릿
public class RegistServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 받기
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		String cwriter = request.getParameter("cwriter");
		String news_idx = request.getParameter("news_idx");
		
		System.out.println("msg is "+msg);
		System.out.println("cwriter is "+cwriter);
		System.out.println("news_idx is "+news_idx);

		
		
	}
}









