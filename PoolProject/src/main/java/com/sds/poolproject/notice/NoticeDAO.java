package com.sds.poolproject.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//이 객체는 오직 notice 테이블에 대한 CRUD만을 담당하는 객체이며, 이외의 로직은 담지 않는다..
//결국 DB 작업만 전담한다고 하여 DAO(Data Access Object) 라 한다 
public class NoticeDAO {
	
	//글쓰기 
	public int insert(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //쿼리실행 결과를 담게 될 변수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//접속 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "seshop", "1234");
			if(con ==null) {
				System.out.println("접속 실패");
			}else {
				String sql="insert into notice(notice_idx, title, writer, content)";
				sql+=" values(seq_notice.nextval, ?,?,?)";
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, notice.getTitle()); //제목을 dto에서 꺼내서 대입
				pstmt.setString(2, notice.getWriter()); //작성자를 dto에서 꺼내서 대입
				pstmt.setString(3, notice.getContent()); //내용을 dto에서 꺼내서 대입 
				
				result=pstmt.executeUpdate();//쿼리실행 
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
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
