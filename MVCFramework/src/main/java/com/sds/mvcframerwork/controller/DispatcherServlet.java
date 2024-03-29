package com.sds.mvcframerwork.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모델2 방식 기반으로 어플리케이션을 구축할 경우, 모든 클라이언트의 요청마다 
//1:1 대응하는 컨트롤러를 매핑하게 되면,  web.xml의 매핑관리가 힘들어 진다..
//즉 유지보수성이 오히려 떨어진다..따라서 기존의 컨트롤러 보다 앞선 위치에 
//모든 요청을 하나의 진입점으로 몰아놓을 수 있는 대표 컨트롤러의 존재로 이 문제를 해결
//한다.. ex) 대기업의 서비스 센터의 업무와 동일하다
//이 클래스는 대형 어플리케이션의 모든~~~~요청을 혼자 받아야 하므로, 어떤 하위컨트롤러가
//업무를 담당해야 할지를 분석하는 등의 ..똑똑한 로직을 작성해야 함..
//참고로 수많은 클래스 명 중에서 DispatcherServlet 이라고 이름을 준 이유는, 
//스프링 창시자인 로드 존슨이 스프링 MVC에서, 이 객체명을 쓰기 때문에... 
public class DispatcherServlet extends HttpServlet{
	/*어떠한 분야의 프로그램을 개발하던지, 이 세상의 모든 컨트롤러 반드시 아래의 순서로 요청을 처리한다.
		[모든 컨트롤러의 일반적 요청 처리 절차]
		
	1) 요청을 받는다
	2) 요청을 분석한다 
	3) 알맞는 로직(모델) 객체에 일 시킨다 
	4) 일시킨 후 결과를 보여줄게 있다면 결과를 저장해놓는다 
	5) 결과 페이지를 보여준다
	*/
	
	//더블코딩이 일어나지 않는 방법???

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	//1단계: 요청을 받는다
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2단계: 요청을 분석한다 (클라이언트의 요청이 무엇인지 파악하여, 적절한 하위 컨트롤러에게 업무 전달)
		System.out.println("클라이언트의 요청 감지");
	}
	
}





















