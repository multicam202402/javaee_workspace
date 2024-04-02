package com.sds.model2app.model.board;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//이 DAO 클래스는 기존의 jdbc를 직접 핸들링하는 방식이 아니라, mybatis 프레임웍을 이용하
//는 DAO로 작성한다
public class BoardDAO {
	
	public int insert() {
		int result=0;	
		SqlSession sqlSession=null; //Mybatis 의 쿼리 수행 객체

		
		
		return result;
	}
}
