	package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class EditCustomer extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement editcustomerlink;
	
	@FindBy(name="cusid")
	WebElement customerid;

}
