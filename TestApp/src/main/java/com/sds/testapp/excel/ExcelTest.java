package com.sds.testapp.excel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTest {
	
	public static void main(String[] args) {
		//URL url = ClassLoader.getSystemResource("D:/javaee_workspace/TestApp/res/test.xlsx");
		//System.out.println(url);
		try {
			File file = new File("D:/javaee_workspace/TestApp/res/test.xlsx");
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet= (Sheet)workbook.getSheetAt(0);
			Iterator it = sheet.iterator();
			
			while(it.hasNext()) {
				Object obj = it.next();
				Row row=(Row)obj;
				System.out.println("결과 "+row.getCell(0).toString()+","+row.getCell(1).toString()); 
			}
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
