package com.specify.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook xssfworkbook;
	FileInputStream fis;
	XSSFSheet sheet;
	
	public ExcelReader(String path, String sheetname) throws IOException
	{
		
		fis = new FileInputStream(new File(path));
		xssfworkbook = new XSSFWorkbook(fis);
		sheet = xssfworkbook.getSheet(sheetname);
		
	}
	
	public int numberOfRowsInExcel()
	{
		
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int numberOfColumnsInExcel()
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	
	public Object[][] getAllData()
	{	
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[rowCount-1][this.numberOfColumnsInExcel()];
		
			for (int i = 1; i < rowCount; i++) {
				Row row1=sheet.getRow(i);
				for (int j = 0; j <colCount; j++) {
					switch(row1.getCell(j).getCellType()) {
					case NUMERIC:
					double d1=row1.getCell(j).getNumericCellValue();
					int value = (int)Math.round(d1);
					obj[i-1][j]=value;
					break;
					case STRING:obj[i-1][j]=row1.getCell(j).getStringCellValue();
					break;
					}
				}
			}
		
		return obj;
	}
}
