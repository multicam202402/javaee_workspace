package com.sds.asynboard.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.asynboard.common.PoolManager;

//이 클래스는, 오직  board 테이블에 대한 CRUD를 수행하기 위한 객체이다 
public class BoardDAO {
	PoolManager pool=new PoolManager(); //수영장 관리 객체 생성
	
	//모든 글 가져오기 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list = new ArrayList();
		
		con = pool.getConnection(); //접속이 아니라, 이미 접속되어 있는 Connection 대여하기!!
		
		String sql="select * from board order by board_idx desc"; //내림차순
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); //쿼리실행 후 표 반환
			
			//rs를 대신할 자료형을 대체...List<Board> 형태가 그 대안 임..
			while(rs.next()) {
				Board board = new Board(); //empty 상태 
				//비어 있는 Board에 rs의 컬럼 값들을 채워넣기!!!
				board.setBoard_idx(rs.getInt("board_idx"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		
	
		return list;
	}
	
	
	//글 1건 등록 
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //insert DML 수행 결과를 담을 변수
				
		con = pool.getConnection();//커넥션은 앞으로 풀매니저에게 빌려오자~!!
		
		String sql="insert into board(board_idx, title, writer, content)";
		sql+=" values(seq_board.nextval, ? ,?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle()); //제목을 꺼내어 바인드변수에 대입
			pstmt.setString(2, board.getWriter());//작성자를 꺼내어 바인드변수에 대입
			pstmt.setString(3, board.getContent());//내용을 꺼내어 바인드변수에 대입
			
			result = pstmt.executeUpdate();//쿼리 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result; //결과 반환
	}
}




