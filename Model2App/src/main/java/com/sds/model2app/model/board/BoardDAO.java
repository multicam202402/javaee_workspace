package com.sds.model2app.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sds.model2app.domain.Board;
import com.sds.model2app.mybatis.MybatisManager;

//이 DAO 클래스는 기존의 jdbc를 직접 핸들링하는 방식이 아니라, mybatis 프레임웍을 이용하
//는 DAO로 작성한다
public class BoardDAO {
	
	//MybatisManager가 SqlSessionFactory를 가지고 있으므로..
	MybatisManager manager=MybatisManager.getInstance(); 
	
	public int insert(Board board) {
		int result=0;	
		SqlSession sqlSession=null; //Mybatis 의 쿼리 수행 객체

		sqlSession = manager.getSqlSession(); //팩토리로부터 쿼리수행 세션 얻기!
		
		//쿼리실행
		result = sqlSession.insert("com.sds.model2app.domain.Board.insert", board);
		sqlSession.commit(); //mybatis는 setAutoCommit()이 false로 되어 있슴
		
		//쿼리수행 객체 반납
		manager.release(sqlSession);
		
		return result;
	}
	
	//모든 레코드 가져오기 
	public List selectAll() {
		List list=null;
		SqlSession sqlSession=null;	
		
		sqlSession=manager.getSqlSession();
		list = sqlSession.selectList("com.sds.model2app.domain.Board.selectAll");
		return list;
	}
	
	
	//레코드 한건 가져오기 
	public Board select() {
		Board board = null;
		
		return board;
	}
}
















