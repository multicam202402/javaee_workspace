package com.sds.asynboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//목록 요청을 처리하는 서블릿
public class ListServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록 요청 들어왔어!!");
		
		//데이터베이스 목록을 가져와서, 클라이언트인 js가 이해할 수 잇는 데이터 형태로 변환하여 응답정보로
		//보내주자...즉 json 으로 보내주자..
		 
	}
}








