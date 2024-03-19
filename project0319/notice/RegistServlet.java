package com.sds.project0319.notice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.sql.*;

//글쓰기 요청을 처리하는 서블릿 클래스 정의
public class RegistServlet extends HttpServlet{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="seshop";
	String pass="1234";
	
	//글쓰기 요청은 post 방식으로 전송되므로, 서블릿 부모가 가진 메서드인 doXXXX형 
	// 중 doPost() 로 처리하자
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//<%@ page contentType="text/html;charset=utf-8"%>
		response.setContentType("text/html;charset=utf-8"); //단축식으로 표현도 가능
		//response.setCharacterEncoding("utf-8");

		//클라이언트가 전송한 파라미터 3개 받기 (한글깨지지 않게 )
		request.setCharacterEncoding("utf-8");

		//파라미터 받기 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		PrintWriter out =response.getWriter(); //응답 객체가 보유한 출력스트림 꺼내기 
		out.print("당신이 전송한 제목은 "+title+"<br>");

		//오라클에 insert 

		Connection con=null;
		PreparedStatement pstmt=null;

		//드라이버 로드 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.print("드라이버 로드 성공");

			con = DriverManager.getConnection(url, user, pass);

			if(con !=null){
				out.print("접속 성공");
			}else{
				out.print("접속 실패");
			}
		}catch(ClassNotFoundException e){
			out.print("드라이버 로드 실패");
		}catch(SQLException e){
			e.printStackTrace(); //톰켓 서버의 로그에 에러 원인 출력 
		}

	}

}
