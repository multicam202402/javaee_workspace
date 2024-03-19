package com.sds.project0319.notice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

//글쓰기 요청을 처리하는 서블릿 클래스 정의
public class  RegistServlet extends HttpServlet{
	
	//글쓰기 요청은 post 방식으로 전송되므로, 서블릿 부모가 가진 메서드인 doXXXX형 
	// 중 doPost() 로 처리하자
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//클라이언트가 전송한 파라미터 3개 받기 (한글깨지지 않게 )
		request.setCharacterEncoding("utf-8");

		//파라미터 받기 

	}

}
