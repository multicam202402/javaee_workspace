package com.sds.dataroom.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

//바이너리 파일이 포함된, 글쓰기 요청을 처리하는 서블릿
public class RegistServlet extends HttpServlet{
	
	//클라이언트가 post 방식으로 전송하므로, doPost() 재정의 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주의) 클라이언트가 바이너리 파일을 첨부하여 보낼 경우 encoding 이 multipart/form-data 이기 
		//때문에 기존의 request.getParameter() 만으로는 문자열만 처리할 수 있으므로, 복합된 인코딩에 대한 파라미터 받기
		//가 불가능..따라서 업로드 컴포넌트를 통해 파라미터들을 처리해야 한다 
		System.out.println("접속자 감지");
		
		/*
		 * 업로드와 관련된 설정: 저장경로, 파일용량.. DiskFileItemFactory
		 * 파일업로드를 담당하는 클래스 : ServletFileUpload 
		 */
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1*1024*1024);//용량  1M
		File file = new File("경로...");
		factory.setRepository(null);
	}
}











