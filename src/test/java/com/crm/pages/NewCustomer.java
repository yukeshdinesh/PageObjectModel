package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class NewCustomer extends TestBase {
	
	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement editcustomerlink;
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newcustomerlink;

	@FindBy(name = "name")
	WebElement customername;

	@FindBy(xpath = "//input[@name='rad1' and @value='m']")
	WebElement male;

	@FindBy(xpath = "//input[@name='rad1' and @value='f']")
	WebElement female;

	@FindBy(id = "dob")
	WebElement dob;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pinno;

	@FindBy(name = "telephoneno")
	WebElement telephoneno;

	@FindBy(name = "emailid")
	WebElement emailid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "sub")
	WebElement sub;

	@FindBy(name = "res")
	WebElement res;
	
	public void OpenNewCustomerPage() {
		newcustomerlink.click();
	}

	public boolean Newcustomerpageisdisplayed() {
		newcustomerlink.click();
		Assert.assertTrue(customername.isDisplayed(), "New Customer page is displayed");
		if(customername.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void EnterCustomerName(String Custname) {
		customername.sendKeys(Custname);
	}

	public void SelectGender(String gender) {
		if (gender.equalsIgnoreCase("male"))
			male.click();
		else
			female.click();
	}

	public void enterDOB(String birthday) {
		dob.sendKeys(birthday);
	}

	public void enteraddress(String addr) {
		address.sendKeys(addr);
	}

	public void entercity(String cit) {
		city.sendKeys(cit);
	}

	public void enterstate(String stat) {
		state.sendKeys(stat);
	}

	public void pincode(String pin) {
		pinno.sendKeys(pin);
	}

	public void phone(String ph) {
		telephoneno.sendKeys(ph);
	}

	public void Enteremail(String email) {
		emailid.sendKeys(email);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterSubmit() {
		sub.click();
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public EditCustomer editCustomer() {
		return new EditCustomer();
	}

}
