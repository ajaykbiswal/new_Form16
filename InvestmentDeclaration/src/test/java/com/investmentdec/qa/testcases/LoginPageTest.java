package com.investmentdec.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.investmentdec.qa.base.TestBase;
import com.investmentdec.qa.pages.HomePage;
import com.investmentdec.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUP() throws Exception{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest(){
		
				String title=loginpage.verifyLoginPageTitle();
				Assert.assertEquals(title, "HR Services");
		
	}
	@Test
	public void hrServicelogoTest() throws Exception{
		
			boolean flag=loginpage.verifyHRservicelogo();
			Assert.assertTrue(flag);
			Thread.sleep(5000);
	}
	
	
    @Test
	public void loginTest() throws Exception {
    		Thread.sleep(5000);
    		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
    		Thread.sleep(5000);
	}
    
    @AfterClass
    public void teardown() throws Exception{
    	Thread.sleep(8000);
    	driver.quit();
    	Thread.sleep(8000);
    }
}
