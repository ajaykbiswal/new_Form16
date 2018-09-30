package com.form16.qa.testcases;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.form16.qa.base.TestBase;
import com.form16.qa.pages.Form16Page;
import com.form16.qa.pages.HomePage;
import com.form16.qa.pages.LoginPage;



public class HomePageTest extends TestBase {
	public static Logger log=Logger.getLogger(HomePageTest.class.getName());
	LoginPage loginpage;
	HomePage homepage;
	Form16Page form16page;
	
	public HomePageTest(){
				super();
	}
	
	
	@BeforeClass
	public void setUP() throws Exception{
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
	}
	
	@Test
	public void homeLabelTest(){
				log.info(" Starting homeLabelTest ");
				logger=extent.createTest("homeLabelTest");
				logger.log(Status.INFO, "HomeLabel Testcase Started !");
				boolean flag=homepage.verifyHomelabel();
				Assert.assertTrue(flag);
				logger.log(Status.INFO, "Navigated to Home page successfully & the value is : "+ flag);
				log.info("Navigated to Home page successfully & the value is : "+ flag);
				boolean flags=homepage.verifyServicelabel();
				Assert.assertTrue(flags);
				log.info(" Service page label validated successfully & the value is : "+ flag);
				logger.log(Status.INFO, "Service page label validated successfully & the value is : "+ flag);
				logger.log(Status.INFO, "HomeLabel Testcase Completed !");
				log.info(" Ending homeLabelTest ");
	}
//	@Test
//	public void bserviceLabelTest(){
//		boolean flag=homepage.verifyServicelabel();
//		Assert.assertTrue(flag);
//	}
	@Test
	public void  clickOnServiceTest()  {
					log.info(" Starting clickOnServiceTest ");
					logger=extent.createTest("clickOnServiceTest");
					logger.log(Status.INFO, " ClickOnServiceTestcase  Started !");
					
					homepage.clickOnServices();
					log.info("Clicked on Service page successfully");
					logger.log(Status.INFO, " Service page clicked successfully !");
					logger.log(Status.INFO, "ClickOnServiceTestcase Completed !");
					log.info(" Ending clickOnServiceTest ");
		
	}
	
	@Test
	public void  form16linkTitleTest(){
					   log.info(" Starting form16linkTitleTest ");
					   logger=extent.createTest("form16linkTitleTest");
					   logger.log(Status.INFO, " Form16linkTitle-Testcase  Started !");
					   boolean flag=homepage.verifyForm16Title();
					   Assert.assertTrue(flag,"Verification failed:  The Form16Title is not displayed correctly on the webpage");
					   logger.log(Status.INFO, "Form16 title verified successfully & the value is : "+ flag);
					   log.info("Form16 title verified successfully & the value is : "+ flag);
					   logger.log(Status.INFO, " Form16linkTitle-Testcase Completed !");
					   log.info(" Ending form16linkTitleTest ");
	}
	@Test
	public void clickOnForm16Test(){
					log.info(" Starting clickOnForm16Test ");
					logger=extent.createTest("clickOnForm16Test");
					logger.log(Status.INFO, " Form16linkTitle Testcase  Started !");
					form16page = homepage.clickOnForm16();
					log.info("Clicked on Form16 successfully");
					log.info("Form16 service Icon clicked succesfully");
				    logger.log(Status.INFO, " Form16linkTitle-Testcase  Completed !");
					log.info(" Ending clickOnForm16Test ");
	}
	
	
}
