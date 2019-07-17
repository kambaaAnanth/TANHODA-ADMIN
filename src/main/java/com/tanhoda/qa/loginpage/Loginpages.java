package com.tanhoda.qa.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




import com.tanhoda.qa.homepage.Homepages;
import com.tanhoda.qa.setup.Initialize;

public class Loginpages extends Initialize {
	
	 @FindBy(id="username")
	 WebElement username;
	 @FindBy(id="password")
	 WebElement password;
	 @FindBy(xpath="//*[@id='form']")
	 WebElement signin;
	 public Loginpages(){
		 PageFactory.initElements(driver, this);
	 }
	 public Homepages validatethelogin(){
		 username.sendKeys(property.getProperty("username"));
		 password.sendKeys(property.getProperty("password"));
		 signin.click();
		return new Homepages();
	 }
	 public String validatetitle(){
		  return driver.getTitle();
		 
	 }
}
