package com.sds.openapp.store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//맛집 목록 요청을 처리하는 서블릿 
public class ListServlet extends HttpServlet{
	//GET 방식 요청 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String perPage = request.getParameter("perPage");
		
		System.out.println("요청받았슴 "+perPage);
	}
}









