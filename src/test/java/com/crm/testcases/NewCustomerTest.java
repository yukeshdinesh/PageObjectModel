package com.crm.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.crm.pages.LoginPage;
import com.crm.pages.NewCustomer;
import com.crm.qa.base.TestBase;
import com.crm.util.TestUtil;

public class NewCustomerTest extends TestBase{
	
	NewCustomer newCustomer;
	LoginPage LoginPage;
	TestUtil testutil;
	
	public NewCustomerTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializaton();
		LoginPage = new LoginPage();
		testutil = new TestUtil();
		newCustomer = LoginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@Test(priority=1)
	public void gettitle() {
		String Pagetitle = newCustomer.title();
		System.out.println(Pagetitle);
		Assert.assertEquals(Pagetitle, "Guru99 Bank Manager HomePage");
	}
	//@Test(priority=2)
	public void CheckNewCustomerPage() {
		boolean bool =newCustomer.Newcustomerpageisdisplayed();
		Assert.assertTrue(bool, "New customer page is not displayed");	
	}
	@Test(priority=3, dataProvider="getData")
	public void FillCustomerDetails(String name,String gender, String dob, String address, String city,String state, String pincode, 
			String phone, String email, String password) {
		try {
				
			newCustomer.OpenNewCustomerPage();
			newCustomer.EnterCustomerName(name);
			newCustomer.SelectGender(gender);
			newCustomer.enterDOB(dob);
			System.out.println(dob);
			testutil.Wait(5);
			newCustomer.enteraddress(address);
			newCustomer.entercity(city);
			newCustomer.enterstate(state);
			newCustomer.pincode(pincode);
			System.out.println(pincode);
			newCustomer.phone(phone);
			newCustomer.Enteremail(email);
			newCustomer.enterPassword(password);
			newCustomer.enterSubmit();
			testutil.Wait(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(testutil.isAlertPresent()) {
			testutil.switchToAlert_Accept_Navigateback();
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = TestUtil.getExcelData("Sheet1");
		return data;
	}
	
	@AfterMethod
	public void wrapup() {
		driver.quit();
	}
	
	
	

}
