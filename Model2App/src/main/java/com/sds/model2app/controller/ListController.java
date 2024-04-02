package com.sds.model2app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//목록 요청을 처리하는 하위 컨트롤러  
public class ListController implements Controller{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 알맞는 모델 객체에 일 시키기
		
		//4단계: 뷰로 가져갈 것이 있다면 결과 저장 
	}

	@Override
	public String getViewName() {
		return "/view/board/list";
	}

	@Override
	public boolean isForward() {
		return true; //결과를 저장한다는 것은 요청을 유지하는 것이므로, 포워딩은 true 로 놓는다
	}

}
