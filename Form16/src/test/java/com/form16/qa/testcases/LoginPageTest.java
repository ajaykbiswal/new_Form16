package com.form16.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.form16.qa.base.TestBase;
import com.form16.qa.pages.HomePage;
import com.form16.qa.pages.LoginPage;
//import com.form16.qa.utility.TestUtil;


public class LoginPageTest extends TestBase {
	public static Logger log=Logger.getLogger(LoginPageTest.class.getName());
	LoginPage loginpage;
	HomePage homepage;

	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUP(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test 
	public void loginPageTitleTest(){
		log.info(" Starting loginPageTitleTest ");
		logger=extent.createTest("loginPageTitleTest");
		String title=loginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "HR Services");
		log.info("Title verified successfully and the value  is: "+ title);
		log.info(" Ending loginPageTitleTest ");
		
	}
	@Test
	public void hrServicelogoTest(){
		log.info(" Starting hrServicelogoTest ");
		boolean flag=loginpage.verifyHRservicelogo();
		logger=extent.createTest("hrServicelogoTest");
		Assert.assertTrue(flag);
		log.info("Logo validated successfully and  the value is :-"+ flag);
		log.info(" Ending hrServicelogoTest ");
	}
	
    @Test 
	public void loginTest() {
    	log.info(" Starting loginTest ");
    	logger=extent.createTest(" loginTest");
     	log.info("Entered UserName :"+pro.getProperty("userName"));
    	log.info("Entered Password :"+pro.getProperty("password"));
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		log.info("Clicked on submit button successfully");
		log.info(" Ending loginTest ");
		
		
	}
    
    
}
