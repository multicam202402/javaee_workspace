package com.sds.dataroom.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sds.dataroom.common.PoolManager;

//dataroom 테이블에 대한 CRUD만을 수행하는 DAO 정의 
public class DataroomDAO {
	PoolManager pool=PoolManager.getInstance();//싱글턴으로 선언된 객체의 인스턴스 얻기
	
	//모든 레코드 가져오기 
	
	//레코드 1건 가져오기 
	
	//1건 등록
	public int insert(Dataroom dataroom) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con = pool.getConnection(); //접속이 아닌, 대여이다 
		
		String sql="insert into dataroom(dataroom_idx, title, writer, content, filename)";
		sql+=" values(seq_dataroom.nextval, ?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql); //쿼리문 객체 생성 
			pstmt.setString(1, dataroom.getTitle());
			pstmt.setString(2, dataroom.getWriter());
			pstmt.setString(3, dataroom.getContent());
			pstmt.setString(4, dataroom.getFilename());
			
			result = pstmt.executeUpdate(); //DML 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt); //자원 해제
		}		
		return result;
	}
	
	//1건 수정 
	
	//1건 삭제
	
}
