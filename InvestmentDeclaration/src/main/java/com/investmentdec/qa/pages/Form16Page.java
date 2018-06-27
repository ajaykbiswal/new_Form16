package com.investmentdec.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.investmentdec.qa.base.TestBase;
import com.investmentdec.qa.utility.TestUtil;

public class Form16Page extends TestBase {
	
	
	@FindBy(how=How.XPATH,using="//li[@class='nav-item']/a[@id='ngb-tab-3']")
	WebElement form16_tab;
	
	@FindBy(how=How.XPATH,using="//li[@class='nav-item']/a[@id='ngb-tab-4']")
	WebElement instruction_tab;
	
	@FindBy(how=How.XPATH,using="//img[@alt='pdf']")
	WebElement pdfdownload_link;
	
	@FindBy(how=How.XPATH,using="//img[@alt='email']")
	WebElement email_link;
	
	public Form16Page(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyForm16TabDisplay() {
		return form16_tab.isDisplayed();
		
	}
	
	
	
	public boolean verifyInstructionTabDisplay(){
		
		return instruction_tab.isDisplayed();
	}
	
	

	public void verifyPdfDownload() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		TestUtil.clickByXpath(driver, pdfdownload_link);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void verifyEmailSent(){
		email_link.click();
	}

}
