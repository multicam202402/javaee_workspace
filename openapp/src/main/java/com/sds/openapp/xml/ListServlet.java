package com.sds.openapp.xml;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//병원 목록 요청을 처리하는 서블릿
public class ListServlet extends HttpServlet{
	
	//클라이언트의 요청이 get방식이므로, doGet() 재정의 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String code = request.getParameter("code");
		
		System.out.println("클라이언트가 전송한 지역 코드는 "+code);
	}
}








