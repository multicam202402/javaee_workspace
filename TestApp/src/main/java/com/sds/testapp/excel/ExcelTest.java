package com.sds.testapp.excel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTest {
	
	public static void main(String[] args) {
		URL url = ClassLoader.getSystemResource("text.xlsx");
		try {
			File file = new File(url.toURI());
			Workbook workbook = WorkbookFactory.create(file);
			She= (Sheet)workbook.getSheetAt(0);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
