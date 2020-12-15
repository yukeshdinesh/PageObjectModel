package com.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Object Repositories
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement resetbutton;
	
	@FindBy(xpath="//img[@alt='Guru99 Demo Sites']")
	WebElement image;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String PagetitleTest() {
		return driver.getTitle();
	}
	
	public boolean ImageTest() {
		return image.isDisplayed();
	}
	
	public NewCustomer LoginTest(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		/*System.out.println(loginbutton.isEnabled());
		loginbutton.click();*/
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", loginbutton);
		
		return new NewCustomer();
	}

}
