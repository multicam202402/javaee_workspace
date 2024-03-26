package com.sds.openapp.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//병원 목록 요청을 처리하는 서블릿
public class ListServlet extends HttpServlet{
	String serviceKey="TPK6sq5VdCOFrijK99CmJHQCEVer9GwK4sxLvP6ED6dBExrBc6FO298QjQadJsw7C4sDZ8yBXJfsYZ/VT6LG0A==";
	
	//클라이언트의 요청이 get방식이므로, doGet() 재정의 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String code = request.getParameter("code");
		
		System.out.println("클라이언트가 전송한 지역 코드는 "+code);
		
		//open api 포탈에서 부여받은 인증키를 이용하여, 원하는 서버의 open api를 이용해보자
		//우리가 만든 html과의 관계에서는 고양이가 서버가 되지만,  외부  open api 서버와 고양이와의 관계에서
		//고양이는 클라이언트 역할을 한다.따라서 Tomcat에서 외부의 웹서버에게 요청을 시도해야 하고, 
		//이때 사용되는 객체가 바로 javaSE에서 지원하는 HttpURLConnection 이다!!!
		
		//요청 주소 문자열이 너무 길 경우, 체계적으로 관리하기 위해 문자열을 분리시켜보자 
		StringBuilder sb = new StringBuilder();
		sb.append("https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList"); //url
		sb.append("?serviceKey="+URLEncoder.encode(serviceKey)); //나만의 인증 서비스키
		sb.append("&numOfRows="+URLEncoder.encode("100", "UTF-8")); //100건 가져오기
		sb.append("&sidoCd="+URLEncoder.encode(code, "UTF-8"));
		
		URL url=new URL(sb.toString());
		URLConnection urlCon=url.openConnection();
		HttpURLConnection con=(HttpURLConnection)urlCon;
		
		//서버에 웹요청 시작 (요청 Header 구성) 
		con.setRequestMethod("GET");  //API 서버에 GET  방식으로 요청 시도
		con.setRequestProperty("Content-Type", "text/xml");
		
		//서버에 요청 후 반환값을 이용한 판단 
		int status = con.getResponseCode(); // 성공일 경우 200이 전송되어옴..
		
		InputStreamReader reader=null; //try 문밖으로 빼놓아야 나중에 닫음
		BufferedReader buffr=null; //한줄씩 읽어들이는 버퍼처리된 문자기반의 입력스트림
		
		if(status==200) {
			
			//입력스트림을 이용하여, 서버로부터 전송되어온 문자열 들을
			
			//바이트 스트림을 문자스트림으로 업그레이드
			reader = new InputStreamReader(con.getInputStream());
			
			//문자 기반 스트림을, 버퍼처리된 스트림으로 업그레이드(이때 부터 한줄씩 읽어들일 수 있다)
			buffr = new BufferedReader(reader);
			
			//데이터 한줄씩 읽어들이기
			String str=null;
			
			while(true) {
				str = buffr.readLine();
				if(str ==null)break;//데이터가 없다면 루프 중단
				System.out.println(str);
			}
		}//end if
		
		//스트림 닫기 
		if(buffr!=null) {
			buffr.close();
		}
		if(reader !=null) {
			reader.close();
		}
		
		//연결 객체 접속 해제
		con.disconnect();
		
	}
}











