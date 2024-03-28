package com.sds.testapp.excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) {
		// 새 XSSFWorkbook 인스턴스 생성
		XSSFWorkbook workbook = new XSSFWorkbook();

		// 워크북 내에 새 시트 생성
		XSSFSheet sheet = workbook.createSheet("Employee Data");

		// 데이터를 입력할 객체 배열 생성
		Object[][] employeeData = { 
			{ "Emp ID", "Name", "Job" }, 
			{ 101, "John Doe", "Software Engineer"},
			{ 102, "Jane Doe", "Project Manager" } 
		};

		// 배열의 데이터를 엑셀 파일의 행과 셀에 입력
		int rowNum = 0; //행을 증가시키기 위한 변수 
		System.out.println("Creating excel");
		
		//층수만큼 반복하면서 Row를 생성
		for (Object[] rowData : employeeData) {
			Row row = sheet.createRow(rowNum++);
			
			int colNum = 0; //셀을 증가시키기 위한 변수 
			
			//Row에 소속된 배열만큼 셀을 생성 
			for (Object field : rowData) {
				Cell cell = row.createCell(colNum++);
				
				if (field instanceof String) { //문자형이면
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) { //숫자형이면
					cell.setCellValue((Integer) field);
				}
			}
		}

		try {
			// 파일 시스템에 엑셀 파일 작성
			FileOutputStream outputStream = new FileOutputStream("D:/javaee_workspace/TestApp/res/emp.xlsx");
			workbook.write(outputStream); //구성된 엑셀내용을 반영할 파일 지정 
			workbook.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
