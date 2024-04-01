package com.sds.mvcproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.mvcproject.notice.model.NoticeDAO;

//게시판의 목록요청을 처리하는 하위 컨트롤러
public class ListController implements Controller{
										/* is  a  */
	NoticeDAO noticeDAO= new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3단계: 알맞는 모델 객체에게 일 시키기
		//모델 객체에게 일 시킨 후 반환 받은 noticeList는 게시물 목록 이므로, 
		//MVC 중 디자인 역할의 View로 전달되어야 함...View는 jsp가 하므로, 
		//어떻게 해서건 noticeList가 죽지 않고 jsp까지 도달되어야 함..
		List noticeList = noticeDAO.selectAll();
		
		
		//4단계:  뷰 페이지로 가져갈 데이터가 있을 경우 결과 저장 (request에 저장) 
		//아직 응답하지 않았다면  request, response가 살아있으므로, 
		//request 객체에 noticeList을 담아서, View 담당인 jsp에게 포워딩하자!!
		//포워딩을 담당하는 객체인 RequestDispatcher 객체를 얻기!
		RequestDispatcher dis=request.getRequestDispatcher("/notice/list.jsp");//포워딩할 주소
		
		
	}
					
	
	
	
	
	
	
	
}