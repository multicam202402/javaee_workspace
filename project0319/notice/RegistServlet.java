package com.sds.project0319.notice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

//�۾��� ��û�� ó���ϴ� ���� Ŭ���� ����
public class  RegistServlet extends HttpServlet{
	
	//�۾��� ��û�� post ������� ���۵ǹǷ�, ���� �θ� ���� �޼����� doXXXX�� 
	// �� doPost() �� ó������
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Ŭ���̾�Ʈ�� ������ �Ķ���� 3�� �ޱ� (�ѱ۱����� �ʰ� )
		request.setCharacterEncoding("utf-8");

		//�Ķ���� �ޱ� 

	}

}
