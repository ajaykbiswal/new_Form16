package com.form16.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.form16.qa.base.TestBase;
import com.form16.qa.pages.Form16Page;
import com.form16.qa.pages.HomePage;
import com.form16.qa.pages.LoginPage;

import com.form16.qa.utility.TestUtil;
import com.form16.qa.utility.Xl;

public class Form16PageTest extends TestBase {
	public static Logger log=Logger.getLogger(Form16PageTest.class.getName());
	LoginPage loginpage;
	HomePage homepage;
	Form16Page form16page;
	
	public Form16PageTest(){
		super();
	}
	
	
	@BeforeClass
	public void setUP(){
		
		initialization();
		loginpage=new LoginPage();
		form16page=new Form16Page();
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		homepage.clickOnServices();
		homepage.clickOnForm16();
	}
	
	@Test 
	public void form16TabTest(){
				log.info(" Starting clickOnForm16Test ");
				  logger=extent.createTest("form16TabTest");
				boolean flag=form16page.verifyForm16TabDisplay();
//				Assert.assertTrue(flag);
				Assert.assertTrue(flag, "Verification failed:  The FormTab is not displayed correctly on the webpage");
				log.info("Form16 tab verified successfully & the value is : "+ flag);
				log.info(" Ending clickOnForm16Test ");
	}
	
	
	
	
	@Test
	public void policyButtonTest(){
		log.info("Starting policyButtonTest");
		  logger=extent.createTest("policyButtonTest");
		boolean flag=form16page.verifyPolicyButton();
		//Assert.assertTrue(flag);
		Assert.assertTrue(flag, "Verification failed:  The policy button  is not displayed correctly on the webpage ");
		log.info("policy button verified successfully & the value is : "+ flag);
		form16page.clickOnPolicyButton();
		log.info("Clicked on policy button sucessfully");
		Assert.assertEquals(form16page.verifyTextonPolicySnippet(), "Investment Declaration Guidelines", "Verification failed: Expected and Actual result do not matched: ");
		log.info("PolicySnippet text verified  successfully");
		form16page.clickOnPolicyCloseButton();
		log.info("Clicked on policy close button sucessfully");
		log.info("Ending  policyButtonTest");	
	}
	
	@Test
	public void leftSpinnerTest(){
			log.info(" Starting leftSpinnerTest ");
			 logger=extent.createTest("leftSpinnerTest");
			form16page.verifyLeftSpinner();
			log.info("Clicked on left spinner sucessfully");
			log.info(" Ending leftSpinnerTest ");
	}
    
	@Test
	public void rightSpinnerTest(){
		log.info("Starting rightSpinnerTest");
		 logger=extent.createTest("rightSpinnerTest");
		form16page.verifyRightSpinner();
		log.info("Clicked on right spinner sucessfully");
		log.info(" Ending rightSpinnerTest ");
	}
	@Test 
	public void instrcutionTabTest(){
				log.info(" Starting instrcutionTabTest ");
				 logger=extent.createTest("instrcutionTabTest");
				boolean flag=form16page.verifyInstructionTabDisplay();
				//Assert.assertTrue(flag);
				Assert.assertTrue(flag, "Verification failed:  The InstructionTab is not displayed correctly on the webpage");
				log.info("Instruction tab verified successfully & the value is : "+ flag);
				TestUtil.deleteFileOperation();
				log.info(" Ending instrcutionTabTest ");
	}
	
	
	@Test 
	public void pdfDownloadTest(){
				log.info(" Starting pdfDownload & pdfFileValidationTest ");
				 logger=extent.createTest("pdfDownloadTest");
				form16page.verifyPdfDownload();
				log.info("Clicked on form16 download successfully");
				String pdfdata=TestUtil.verifyPdfFile();
				Assert.assertTrue(pdfdata.contains("FORM NO. 161")," Verification failed: Expected and Actual result do not matched : ");
				log.info("PDF text verified  successfully");
				log.info(" Ending pdfDownloadTest & pdfFileValidationTest ");
	}
	

	
	 @Test
	 public void instructiontabTextTest(){
		  
		 log.info("Starting instructiontabTextTest");
		 logger=extent.createTest(" instructiontabTextTest");
		 form16page.clickonInstructionTab();
		 log.info("Clicked on instruction tab sucessfully");
		 //Assert.assertTrue( form16page.verifyinstructionTabText().contains("validate signature1"));
		 Assert.assertEquals(form16page.verifyinstructionTabText(), "Click on validate signatures", "Verification failed: Expected and Actual result do not matched: ");
		 log.info("Instructiontab text verified  successfully");
		 log.info("Ending instructiontabTextTest");
		 
	
	 }
	
	 
	
	
}
