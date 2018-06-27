package com.form16.qa.testcases;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
				boolean flag=homepage.verifyHomelabel();
				logger=extent.createTest("homeLabelTest");
				Assert.assertTrue(flag);
				log.info("Navigated to Home page successfully & the value is : "+ flag);
				boolean flags=homepage.verifyServicelabel();
				Assert.assertTrue(flags);
				log.info(" Service page label validated successfully & the value is : "+ flag);
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
					homepage.clickOnServices();
					log.info("Clicked on Service page successfully");
					log.info(" Ending clickOnServiceTest ");
		
	}
	
	@Test
	public void  form16linkTitleTest(){
					   log.info(" Starting form16linkTitleTest ");
					   logger=extent.createTest("form16linkTitleTest");
					   boolean flag=homepage.verifyForm16Title();
					   Assert.assertTrue(flag);
					   log.info("Form16 title verified successfully & the value is : "+ flag);
					   log.info(" Ending form16linkTitleTest ");
	}
	@Test
	public void clickOnForm16Test(){
					log.info(" Starting clickOnForm16Test ");
					logger=extent.createTest("clickOnForm16Test");
					form16page = homepage.clickOnForm16();
					log.info("Clicked on Form16 successfully");
					log.info(" Ending clickOnForm16Test ");
	}
	
	
}
