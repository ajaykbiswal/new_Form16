package com.form16.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
			    logger.log(Status.INFO, " Form16Tab-Verification-Testcase  Started !");
				boolean flag=form16page.verifyForm16TabDisplay();
				Assert.assertTrue(flag, "Verification failed:  The Form16Tab is not displayed correctly on the webpage");
				 logger.log(Status.INFO, "Form16 Tab verified successfully & the value is : "+ flag);
				
				log.info("Form16 tab verified successfully & the value is : "+ flag);
				log.info(" Ending clickOnForm16Test ");
				logger.log(Status.INFO, "Form16Tab-Verification-Testcase Completed !");
	}
	
	
	
	
	@Test
	public void policyButtonTest(){
		log.info("Starting policyButtonTest");
		logger=extent.createTest("policyButtonTest");
		logger.log(Status.INFO, "verifyPolicyButton-Test case Started!");
		boolean flag=form16page.verifyPolicyButton();
		Assert.assertTrue(flag, "Verification failed:  The policy button  is not displayed correctly on the webpage ");
		 logger.log(Status.INFO, "policy button verified successfully & the value is : "+ flag);
		log.info("policy button verified successfully & the value is : "+ flag);
		
		
		form16page.clickOnPolicyButton();
		log.info("Clicked on policy button successfully");
	    logger.log(Status.INFO, "policy button clicked successfully ");
		Assert.assertEquals(form16page.verifyTextonPolicySnippet(), "Investment Declaration Guidelines1", "Verification failed: Expected and Actual result do not matched: ");
		logger.log(Status.INFO, "PolicySnippet text verified  successfully ");
		
		log.info("PolicySnippet text verified  successfully");
		form16page.clickOnPolicyCloseButton();
		logger.log(Status.INFO, "policy close button clicked successfully ");
		log.info("Clicked on policy close button successfully");
		log.info("Ending  policyButtonTest");	
		logger.log(Status.INFO, "verifyPolicyButton-Test case Ended !");
		
	}
	
	@Test
	public void leftSpinnerTest(){
			log.info(" Starting leftSpinnerTest ");
			logger=extent.createTest("leftSpinnerTest");
		    logger.log(Status.INFO, "verify leftSpinnerTest case Started !");
			form16page.verifyLeftSpinner();
			logger.log(Status.INFO, "clicked on left spinner successfully");
			log.info("Clicked on left spinner successfully");
			log.info(" Ending leftSpinnerTest ");
			logger.log(Status.INFO, "verify leftSpinnerTest case Ended !");
			
	}
    
	@Test
	public void rightSpinnerTest(){
		log.info("Starting rightSpinnerTest");
		logger=extent.createTest("rightSpinnerTest");
		logger.log(Status.INFO, "rightSpinnerTest case Started !");
		 
		form16page.verifyRightSpinner();
		log.info("Clicked on right spinner successfully");
		logger.log(Status.INFO, "clicked on right spinner successfully");
		log.info(" Ending rightSpinnerTest ");
		logger.log(Status.INFO, "rightSpinnerTest case Ended !");
		
	}
	@Test 
	public void instrcutionTabTest(){
				log.info(" Starting instrcutionTabTest ");
				logger=extent.createTest("instrcutionTabTest");
				logger.log(Status.INFO, "instrcutionTabTestcase Started !");
				boolean flag=form16page.verifyInstructionTabDisplay();
				
				Assert.assertTrue(flag, "Verification failed:  The InstructionTab is not displayed correctly on the webpage");
				logger.log(Status.INFO, "instruction tab verified successfully & the value is : "+ flag);
				log.info("Instruction tab verified successfully & the value is : "+ flag);
				TestUtil.deleteFileOperation();
				log.info("deleteFileOperation done successfully ");
				log.info(" Ending instrcutionTabTest ");
				logger.log(Status.INFO, "instrcutionTabTestcase Ended !");
				
	}
	
	
	@Test 
	public void pdfDownloadTest(){
				log.info(" Starting pdfDownload & pdfFileValidationTest ");
				logger=extent.createTest("pdfDownloadTest");
				logger.log(Status.INFO, "pdfDownloadTest case Started !");
				form16page.verifyPdfDownload();
				logger.log(Status.INFO, " form16 pdf download link clicked  successfully !");
				log.info("Clicked on form16 download successfully");
				String pdfdata=TestUtil.verifyPdfFile();
				Assert.assertTrue(pdfdata.contains("FORM NO. 161")," Verification failed: Expected and Actual result do not matched : ");
				logger.log(Status.INFO, "PDF text verified  successfully !");
				log.info("PDF text verified  successfully");
				log.info(" Ending pdfDownloadTest & pdfFileValidationTest ");
				logger.log(Status.INFO, "pdfDownloadTest case Ended !");
				
	}
	

	
	 @Test
	 public void instructiontabTextTest(){
		  
		 log.info("Starting instructiontabTextTest");
		 logger=extent.createTest(" instructiontabTextTest");
		 logger.log(Status.INFO, " instructiontabTextTest case Started !");
		 form16page.clickonInstructionTab();
		 log.info("Clicked on instruction tab sucessfully");
		 logger.log(Status.INFO, "  instruction tab clicked sucessfully !");
		 //Assert.assertTrue( form16page.verifyinstructionTabText().contains("validate signature1"));
		 Assert.assertEquals(form16page.verifyinstructionTabText(), "Click on validate signatures", "Verification failed: Expected and Actual result do not matched: ");
		 logger.log(Status.INFO, " instructiontab text verified  successfully !");
		 log.info("instructiontab text verified  successfully");
		 log.info("Ending instructiontabTextTest");
		 logger.log(Status.INFO, " instructiontabTextTest case Ended !");
		 
	
	 }
	
	 
	
	
}
