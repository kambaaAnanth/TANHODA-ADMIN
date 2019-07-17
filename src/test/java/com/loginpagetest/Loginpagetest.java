package com.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tanhoda.qa.homepage.Homepages;
import com.tanhoda.qa.setup.Initialize;

public final class Loginpagetest extends Initialize{
      com.tanhoda.qa.loginpage.Loginpages Loginpages;
  public static Homepages homepages;
        public Loginpagetest(){
        	super();
        }
	@BeforeMethod
	public void setup(){
		commonfunction();
		homepages=new Homepages();
		Loginpages=new com.tanhoda.qa.loginpage.Loginpages();
	}
	@Test
	public void verifyloginpage(){
	homepages=Loginpages.validatethelogin();
	}
	@Test
	public void verifypagetitle(){
		String actual=Loginpages.validatetitle();
		Assert.assertEquals(actual, "TANHODA");
	}
	@AfterMethod
	public void teardown(){
		driver.close();
		
	}
}