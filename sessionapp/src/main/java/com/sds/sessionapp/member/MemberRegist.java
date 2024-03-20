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
		
		
		//클라이언트가 전송한 입력 양식의 파라미터들 받기
		request.setCharacterEncoding("utf-8"); //파라미터의 인코딩 처리(한글 안깨지게)
		
		String id 			= request.getParameter("id"); //아이디
		String pass 		= request.getParameter("pass"); //비밀번호
		String name 		= request.getParameter("name"); //이름 
		String email 		= request.getParameter("email"); //이메일 
		String receive 	= request.getParameter("receive"); //광고 메일 수신 여부
		
		System.out.println("id = "+id);
		System.out.println("pass = "+pass);
		System.out.println("name = "+name);
		System.out.println("email = "+email);
		System.out.println("receive = "+receive);
		
		String[] skillArray = request.getParameterValues("skill");
		
		for(String skill  : skillArray) {
			System.out.println(skill);
		}
		
		//비밀번호에 대한 암호화 해시값 처리 
		
		//오라클에 넣기 
		
		//회원가입 축하 메일 발송 
	}
}




