package com.sds.newsapp.comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 댓글 요청을 처리하는 서블릿 
public class ListServlet extends HttpServlet{
	
	CommentsDAO commentsDAO;
	
	public ListServlet() {
		commentsDAO =new CommentsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 받기 
		String news_idx = request.getParameter("news_idx");
		
		System.out.println("클라이언트가 전송한 news_idx 는 "+news_idx);
		
		commentsDAO.selectAllByFkey(Integer.parseInt(news_idx));
		
	}
}






