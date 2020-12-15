package com.crm.testcases;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy {
	
	@Test(dataProvider="getdata")
	public void test(String name,String gender, String dob, String address, String city,String state, String pincode, 
			String phone, String email, String password) {
		
		System.out.println(name + gender + dob);
		
	}
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] data = getExcelData("Sheet1");
		return data;
		
	}
	
public static Object[][] getExcelData(String Sheetname) {
		
		FileInputStream fis = null;
		try {fis = new FileInputStream("C:\\Users\\yukes\\eclipse-workspace\\POM\\src\\test\\java\\com\\crm\\testdata\\TestData.xlsx");} 
		catch (Exception e) {	e.printStackTrace();}
		
		XSSFWorkbook workbook = null;
		try {workbook = new XSSFWorkbook(fis);} 
		catch (Exception e) {e.printStackTrace();}
		
		
		 XSSFSheet sheet = workbook.getSheet(Sheetname);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				//row.getCell(j).getStringCellValue();
			}
		}
		return data;

	}

}
