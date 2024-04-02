package com.sds.model2app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.model2app.domain.Board;
import com.sds.model2app.model.board.BoardDAO;

//글쓰기 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	
	BoardDAO boardDAO= new BoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 알맞는 모델 객체에 일 시킨다...
		//request.setCharacterEncoding(""); //이미 필터에서 처리했슴!!
		
		Board board = new Board(); //empty 상태 
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		int result = boardDAO.insert(board);
		System.out.println("등록 결과 : "+result);
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
