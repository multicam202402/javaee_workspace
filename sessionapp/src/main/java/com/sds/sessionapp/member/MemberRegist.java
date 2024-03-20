package com.sds.sessionapp.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberRegist extends HttpServlet{
	//회원가입 폼으로부터 전송되는 파라미터들은 Post 방식으로 요청이 되므로, doXXX형 메서드 중 doPost()
	//로 처리하자 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 감지"); //콘솔에 출력 
	}
}




