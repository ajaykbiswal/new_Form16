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
import com.investmentdec.qa.pages.Form16Page;
import com.investmentdec.qa.pages.HomePage;
import com.investmentdec.qa.pages.LoginPage;
import com.investmentdec.qa.utility.TestUtil;



public class HomePageTest extends TestBase {
	
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
	public void ahomeLabelTest(){
		
		boolean flag=homepage.verifyHomelabel();
		Assert.assertTrue(flag);
			
		
	}
	@Test
	public void bserviceLabelTest(){
		boolean flag=homepage.verifyServicelabel();
		Assert.assertTrue(flag);
	}
	@Test
	public void cclickOnServiceTest()  {
		
		homepage.clickOnServices();
		
	}
	
	@Test
	public void form16linkTitleTest(){

		boolean flag=homepage.verifyForm16Title();
		Assert.assertTrue(flag);
	}
	@Test
	public void clickOnForm16Test(){
		
		form16page = homepage.clickOnForm16();
	}
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
	
	
}
