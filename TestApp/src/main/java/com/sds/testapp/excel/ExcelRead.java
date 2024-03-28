package com.sds.testapp.excel;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		// URL url =
		// ClassLoader.getSystemResource("D:/javaee_workspace/TestApp/res/test.xlsx");
		// System.out.println(url);
		try {
			Workbook workbook = new XSSFWorkbook("D:/javaee_workspace/TestApp/res/test.xlsx");
			
			Sheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellType() == CellType.STRING) {
						System.out.print(currentCell.getStringCellValue() + "--");
					} else if (currentCell.getCellType() == CellType.NUMERIC) {
						System.out.print(currentCell.getNumericCellValue() + "--");
					}
				}
				System.out.println();
			}
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
