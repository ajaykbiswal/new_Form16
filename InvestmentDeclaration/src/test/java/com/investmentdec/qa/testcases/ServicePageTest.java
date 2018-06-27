//package com.investmentdec.qa.testcases;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.investmentdec.qa.base.TestBase;
//import com.investmentdec.qa.pages.Form16Page;
//import com.investmentdec.qa.pages.HomePage;
//import com.investmentdec.qa.pages.LoginPage;
//import com.investmentdec.qa.pages.ServicesPage;
//
//public class ServicePageTest extends TestBase {
//	
//	
//	LoginPage loginpage;
//	HomePage homepage;
//	ServicesPage servicepage;
//	Form16Page form16page;
//	
//	public ServicePageTest(){
//		super();
//	}
//	
//	
//	@BeforeMethod
//	public void setUP(){
//		initialization();
//		loginpage=new LoginPage();
//		servicepage=new ServicesPage();
//		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
//		servicepage=homepage.clickOnServices();
//	}
//	@Test(priority=1)
//	public void form16linkTest(){
//
//		boolean flag=servicepage.verifyForm16Link();
//		Assert.assertTrue(flag);
//	}
//	@Test(priority=2)
//	public void clickOnForm16Test(){
//		
//		form16page=servicepage.clickOnForm16();
//	}
//	
//	@AfterMethod
//	public void teardown(){
//		
//		driver.quit();
//	}
//	
//}
