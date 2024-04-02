package com.sds.model2app.common;

//페이징 처리를 일일이 하다보면 코드가 중복되고 복잡해지기 때문에, 페이징 처리를 전담하는 공통객체를
//정의한다 

public class Pager {
	private int totalRecord; //총 레코드 수 
	private int pageSize=10; //페이지당 보여질 레코드 수
	private int totalPage; //총 페이지 수
	private int blockSize=10;//블럭당 보여질 페이지 수 
	private int currentPage=1; //유저가 현재 보는 페이지 
	private int firstPage; //블럭당 반복문의 시작 페이지 
	private int lastPage; //블럭당 반복문의 마지막 페이지
	private int curPos; //페이지당 list의 시작 인덱스
	private int num; //페이지당 시작 번호
	
	
}
