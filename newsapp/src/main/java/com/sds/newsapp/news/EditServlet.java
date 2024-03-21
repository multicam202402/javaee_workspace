package com.sds.newsapp.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//수정 요청을 처리하는 서블릿 정의 
public class EditServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 넘겨받아, 오라클 업데이트 시키자..그리고 상세 페이지 보여주자 
		//주의) 직접 오라클 연동하지 말고, 기존의 CRUD를 담당하는 객체인 DAO한테 시키자!!
		//왜? 개발의 효율성때문에...시간 == 돈... 
		
		request.setCharacterEncoding("utf-8"); //다국어 깨지지 않도록 인코딩
		
		//update news set title=?, writer=?, content=? where news_idx=?
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String news_idx = request.getParameter("news_idx");
		
		System.out.println("title is "+title);
		System.out.println("writer is "+writer);
		System.out.println("content is "+content);
		System.out.println("news_idx is "+news_idx);
		
	}
}








