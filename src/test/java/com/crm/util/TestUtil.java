package com.crm.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Implicit_wait = 10;
	public static long PageLoad_wait = 20;
	

	public void switchToFrame(String FrameName) {
		driver.switchTo().frame(FrameName);
	}

	public void Wait(int num) {
		try {
			Thread.sleep(num * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchToAlert_Accept_Navigateback() {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	public boolean isAlertPresent() {
		if (ExpectedConditions.alertIsPresent() != null) {
			return true;
		} else {
			return false;
		}
	}

	public static String[][] getExcelData(String Sheetname) {

		
		FileInputStream fis = null;
		try {fis = new FileInputStream("C:\\Users\\yukes\\eclipse-workspace\\POM\\src\\test\\java\\com\\crm\\testdata\\TestData.xlsx");} 
		catch (Exception e) {	e.printStackTrace();}
		
		XSSFWorkbook workbook = null;
		try {workbook = new XSSFWorkbook(fis);} 
		catch (Exception e) {e.printStackTrace();}
		
		
		 XSSFSheet sheet = workbook.getSheet(Sheetname);
		 String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				//row.getCell(j).getStringCellValue();
			}
		}
		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
}


