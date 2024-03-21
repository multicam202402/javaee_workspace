package com.sds.newsapp.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	//목록 가져오기 메서드 정의 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<News> list=new ArrayList<News>(); //DTO 들을 담게될 리스트 size = 0
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			
			String sql="select * from news order by news_idx desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			/*rs 는  finally 반드시 닫아야 한다..
			 *하지만, rs를 가져간 객체에서(list.jsp)에서 닫힌 rs를 사용할 수 없는 모순이 발생하므로, 
			 *이 문제를 해결하려면 rs를 대신할 수 잇는 자바의 자료형을 개발자가 만들어 내면 된다.
			 *기왕 만드는 김에 객체지향 개념을 듬뿍 반영한 객체로 가자
			 *
			 * db 분야와 oop분야는 둘다 현실의 사물을 표현하려고 한다..
			 *                 사물 (뉴스)                                            데이터 
			 * db             news라는  table로 거푸집 표현                 record (하나의 행(row)) 
			 * oop           news라는 class로 거푸집 표현                   인스턴스 
			 * */ 
			
			while(rs.next()) { //커서 한컨 전진 
				
				//한건의 레코드를 담게될 비어 있는 dTO 생성 
				News news = new News();
				
				//채워넣을때는 setter() 사용 
				news.setNews_idx(rs.getInt("news_idx"));
				news.setTitle(rs.getString("title"));
				news.setWriter(rs.getString("writer"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
				
				list.add(news); //리스트에 DTO 인스턴스 1개 담기
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return list; //(DTO가 담겨진)리스트 반환 
	}
	
	
	
	//게시물 한건 가져오기 
	public News select(int news_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		News news=null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			
			String sql="select * from news where news_idx=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, news_idx);
			rs=pstmt.executeQuery(); //select문 수행 후 rs반환
			
			//게시물 1건의 정보가 rs에 들어있으므로, rs 는 곧 닫히게 되면 , 외부에서 rs받은자가 
			//사용할 수 없게 되는데, 따라서 rs에 들어있는 레코드 한건을 DTO 인스턴스 1개에 옮겨심고
			//rs 는 죽여버리자
			
			if(rs.next()) {//레코드가 있다면...
				news = new News(); //텅~~ 빈 뉴스 DTO 한개 생성하기(빈 깡통)
				//rs의 데이터를 옮겨심자!!!
				news.setNews_idx(rs.getInt("news_idx"));
				news.setTitle(rs.getString("title"));
				news.setWriter(rs.getString("writer"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return news;
	} 
}









