package com.sds.asynboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//글 한건에 대한 요청을 처리하는 서블릿
public class DetailServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 받기 
		String board_idx = request.getParameter("board_idx");
		
		System.out.println("board_idx is "+board_idx);
		
	}
}









