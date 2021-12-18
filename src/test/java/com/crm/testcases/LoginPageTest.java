package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.pages.LoginPage;
import com.crm.pages.NewCustomer;

public class LoginPageTest extends TestBase{
	LoginPage LoginPage;
	NewCustomer NewCustomer;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializaton();
		LoginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void CheckPageTitle() {
		String title =LoginPage.PagetitleTest();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	
	@Test(priority=2)
	public void CheckImage() {
		Boolean bool =LoginPage.ImageTest();
		Assert.assertTrue(bool);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		 NewCustomer= LoginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void LoginTest2() {
		 NewCustomer= LoginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
