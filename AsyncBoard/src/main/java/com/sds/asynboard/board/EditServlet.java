package com.sds.asynboard.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//수정 요청을 처리하는 서블릿
public class EditServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//파라미터 받기 (4개) 
		String title			= request.getParameter("title");
		String writer		= request.getParameter("writer");
		String content		= request.getParameter("content");
		String board_idx	= request.getParameter("board_idx");
		
		System.out.println("title is "+title);
		System.out.println("writer is "+writer);
		System.out.println("content is "+content);
		System.out.println("board_idx is "+board_idx);
		
	}
}









