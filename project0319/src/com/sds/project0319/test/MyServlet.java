package com.sds.project0319.test;

import javax.servlet.http.HttpServlet; //jsp��� �������� ��û�� ó���ϴ� ���� Ŭ���� 
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest; // ��û ��ü 
import javax.servlet.http.HttpServletResponse; //���� ��ü 
import java.io.PrintWriter;

//�� Ŭ������ ���� pc�� �ƴ϶�, ���� ������������ ���� �� �� �ִ� 
//Ŭ�����̸�, �̷��� ������ javaEE����� Ŭ������ ������ ����(Servlet)�̶� �Ѵ�
public class MyServlet extends HttpServlet{
	//�� Ŭ������ Ŭ���̾�Ʈ�� ���������� ��û�� �õ��Ҷ�, ���۵Ǵ� Ŭ�����̸�, 
	//������ jsp�� �ϴ� ������ �״�� �����Ѵ� 


	//�� �޼���� HttpServlet�� ������ doXXX�� �޼��� �� �ϳ��ν�, Ŭ���̾�Ʈ�� 
	//get������� ��û�� �õ��ϸ� �����ϴ� �޼����̴�..�׸��� ������ throws�� 
	//try~catch���� �����ڰ� ó���ϰ� ����������, �� �޼��� ȣ���ڿ���  ����ó����
	//����(å������)��Ű�� ����̴�..
	//���� �Ʒ��� �޼���� Ŭ���̾�Ʈ�� ��û�� ó���ؾ� �ϹǷ�,  jsp������ request�� response
	//�Ʒ��� �޼��忡���� �����ϰ� �ʿ��ϰ� �ȴ�..���� �Ű������� �־����� 
	//jsp������ request ���尴ü�� �ڷ��� : HttpServletRequest ����.
	//jsp������ response ���尴ü�� �ڷ��� : HttpServletResponse ����.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Ŭ���̾�Ʈ�� ���������� ����� �޽��� ��� 
		//������ Ŭ����������� �����ڰ� ������ �ڵ带 �ۼ��ؾ� �ϹǷ�, ���尴ü ������ ��������
		//�ʴ´�!!

		//���� ��ü�� ������ ��� ��Ʈ���� ���
		PrintWriter out=response.getWriter();	

		//���䰴ü�� ������ ��� ��Ʈ���� ���ڿ��� �������ѳ���!
		out.print("My First Servlet<br> success !!");
	}
}
