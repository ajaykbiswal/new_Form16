package com.investmentdec.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.investmentdec.qa.base.TestBase;
import com.investmentdec.qa.pages.Form16Page;
import com.investmentdec.qa.pages.HomePage;
import com.investmentdec.qa.pages.LoginPage;
import com.investmentdec.qa.utility.TestUtil;


public class Form16PageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	Form16Page form16page;
	
	public Form16PageTest(){
		super();
	}
	
	
	@BeforeClass
	public void setUP() throws Exception{
		initialization();
		loginpage=new LoginPage();
		form16page=new Form16Page();
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		homepage.clickOnServices();
		homepage.clickOnForm16();
	}
	
	@Test(priority=0)
	public void form16TabTest(){
		
		boolean flag=form16page.verifyForm16TabDisplay();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void instrcutionTabTest(){
		
		boolean flag=form16page.verifyInstructionTabDisplay();
		Assert.assertTrue(flag);
		TestUtil.deleteFileOperation();
	}
	

	@Test  (priority=2)
	public void pdfDownloadTest(){
			form16page.verifyPdfDownload();	
			String pdfdata=TestUtil.verifyPdfFile();
			Assert.assertTrue(pdfdata.contains("FORM NO. 16"));		
	}
	
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
	
	
}
