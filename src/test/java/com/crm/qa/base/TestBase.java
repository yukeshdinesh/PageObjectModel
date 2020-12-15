package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\crm\\config\\config.properties");
			prop.load(fis);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initializaton() {
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("opera")) {
			driver = new OperaDriver();
		}
		
		 e_driver = new EventFiringWebDriver(driver);
		WebEventListener listener =new WebEventListener();
		e_driver.register(listener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoad_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
