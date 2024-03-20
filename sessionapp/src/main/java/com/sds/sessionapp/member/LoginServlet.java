package com.sds.sessionapp.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.sessionapp.common.EncryptionManager;

public class LoginServlet extends HttpServlet{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="seshop";
	String password="1234";
	
	//클라이언트가 전송한 데이터가, 비밀번호가 포함되어 있기 때문에 post 방식으로 요청을 들어오므로, 
	//doXXX 형 중 doPost() 처리하자 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); //jsp의 page 지시영역에 해당 
		PrintWriter out = response.getWriter(); //html 문서를 구성하기 위한 출력스트림 
		
		//클라이언트가 전송한 파라미터 받기
		String id=request.getParameter("id");
		String pass= EncryptionManager.getHashFromText(request.getParameter("pass")) ;
		
		System.out.println("아이디는 "+id);
		System.out.println("패스워드는 "+pass);
		
		//넘겨받은 계정 정보가 오라클이 있다면..회원인증을 처리, 세션에 저장해놓고  이 회원이 브라우저를
		//꺼버리지 않는 동안은 데이터를 유지해주자!!
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver); //드라이버 로드 
			
			con = DriverManager.getConnection(url, user, password);
			
			if(con==null) {
				System.out.println("접속 실패");
			}else {
				//회원 조회 쿼리 실행 
				String sql="select * from member where id=? and pass=?";
				
				pstmt = con.prepareStatement(sql); //쿼리 객체 생성
				
				//바인드 변수값 결정 
				pstmt.setString(1, id); //사용자 id 파라미터값
				pstmt.setString(2, pass); //사용자 pass 파라미터 값
				
				//쿼리 실행 후 결과 ResultSet 받기 
				rs = pstmt.executeQuery(); 
				
				//만일 회원이 존재한다면 rs.next() true가 반환됨 
				if(rs.next()) { //커서 이동이 가능하다는 것은, 레코드가 존재한다는 것임..
					//이 회원만의 서비스를 제공...서버가 이 회원을 계속 기억하는 것처럼 해주자..
					//세션객체 얻기 
					HttpSession session=request.getSession(); //이 요청과 관련된 세션을 얻는다!!

					//session.setAttribute(sql, session); //회원 정보를 담는다...
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
}













