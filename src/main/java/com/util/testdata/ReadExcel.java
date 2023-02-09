package com.util.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {

	
	
	@DataProvider
	public static String[][] testdata() throws IOException {
		// TODO Auto-generated method stub

		File excelfile = new File("/Users/shwetha.mahadeva/eclipse-workspace/FreeCRMPageObjectModel/src/main/java/com/util/testdata/test.xls");
		System.out.println(excelfile.exists());
		
		FileInputStream fis = new FileInputStream(excelfile);
		
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
	HSSFSheet sheet1 = workbook.getSheet("contacts");
		
	int total_rows = sheet1.getPhysicalNumberOfRows();
	
	System.out.println("Total no of rows is "+total_rows);
	
	
	
	int total_cols = sheet1.getRow(0).getPhysicalNumberOfCells();
	String[][] data = new String[total_rows-1][total_cols];
	for(int i=0;i<total_rows-1;i++)
	{
		HSSFRow row = sheet1.getRow(i+1);
		
		for(int j=0;j<total_cols;j++)
		{
			System.out.print(row.getCell(j).getStringCellValue());
			data[i][j]=row.getCell(j).getStringCellValue();
		}
	}
		
		
		
		
		workbook.close();
		
		fis.close();
		
		return data;
		
	}

}
