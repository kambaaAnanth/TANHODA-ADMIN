package com.tanhoda.qa.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tanhoda.qa.utils.Util;

public class Initialize {
   public static Properties property;
   public static WebDriver driver;
	 public Properties loadproperty(){
		 property=new Properties();
		 try {
			FileInputStream stream=new FileInputStream("C:\\Users\\kavya\\Desktop\\TANHODA\\TANHODA.ADMIN\\src\\main\\java\\com\\tanhoda\\qa\\testbase\\config.properties");
			   try {
				property.load(stream);
				return property;
			} catch (IOException e) {		
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		return null;
	 }
	 public void commonfunction(){
		 loadproperty();
	 String browser=property.getProperty("browser");
	 String driverlocation=property.getProperty("driverlocation");
	
	if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", driverlocation);
		driver=new ChromeDriver();
		
	}else if(browser.equals("Firefox")){
		System.setProperty("webdriver.gecko.driver", driverlocation);
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Util.pageLoadTimeout, TimeUnit.SECONDS);	
	driver.manage().timeouts().implicitlyWait(Util.implicitwait, TimeUnit.SECONDS);
	driver.get(property.getProperty("url"));
}
}