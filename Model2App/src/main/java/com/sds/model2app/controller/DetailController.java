package com.sds.model2app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.model2app.model.board.BoardDAO;

//상세보기 요청을 처리하는 하위 컨트롤러  
public class DetailController implements Controller{
	BoardDAO boardDAO  = new BoardDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 알맞는 모델 객체에 일 시킨다 
	}

	public String getViewName() {
		return null;
	}

	public boolean isForward() {
		return false;
	}
	
}
