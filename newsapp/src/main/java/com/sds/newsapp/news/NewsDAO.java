package com.sds.newsapp.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *이 클래스는 javaEE 건, javaSE 건 DB의 특정 테이블에 대해 
 *Create(=insert), Read(=select), Update, Delete  CRUD를 수행하는 중립적 객체로 정의하자 
 *왜 중립적으로 정의해놓아야 하나? 플랫폼에 독립적인 재사용 객체로 정의하기 위해
 * */
public class NewsDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="seshop";
	String pass="1234";
	
	//create , insert 
	//아래의 메서드를 호출하는 자는 1건의 뉴스기사가 이미 채워진 상태로, 매개변수로 넘겨야 한다.. 
	public int insert(News news) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //실패로 놓자 
		
		try {
			Class.forName(driver);//드라이버 로드
			System.out.println("드라이버 로드");
			con = DriverManager.getConnection(url, user, pass);
			
			StringBuffer sb = new StringBuffer();
			sb.append("insert into news(news_idx, title, writer, content)");
			sb.append(" values(seq_news.nextval, ?,?,?)"); 

			pstmt = con.prepareStatement(sb.toString()); //쿼리 객체 생성
			
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getWriter());
			pstmt.setString(3, news.getContent());
			
			result = pstmt.executeUpdate(); //쿼리실행
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		
		return result;
	}
	
}
