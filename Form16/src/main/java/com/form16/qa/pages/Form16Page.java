package com.form16.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.form16.qa.base.TestBase;
import com.form16.qa.utility.TestUtil;

public class Form16Page extends TestBase {
	
	//public static final Logger log=Logger.getLogger(Form16Page.class.getName());
	
	@FindBy(how=How.XPATH,using="//li[@class='nav-item']/a[@id='ngb-tab-3']")
	WebElement form16_tab;
	
	@FindBy(how=How.XPATH,using="//li[@class='nav-item']/a[@id='ngb-tab-4']")
	WebElement instruction_tab;
	
	@FindBy(how=How.XPATH,using="//img[@alt='pdf']")
	WebElement pdfdownload_link;
	
	@FindBy(how=How.XPATH,using="//img[@alt='email']")
	WebElement email_link;
	
	@FindBy(how=How.XPATH,using="//*[@id='ngb-tab-3-panel']/div/app-finyear-list/div/div/div/button[1]")
	WebElement leftspinner;
	
	@FindBy(how=How.XPATH,using="//*[@id='ngb-tab-3-panel']/div/app-finyear-list/div/div/div/button[2]")
	WebElement rightspinner;
	
	@FindBy(how=How.XPATH,using="//a[@class='cta-doc']")
	WebElement policybutton;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Guidelines')]")
	WebElement policysnippet;
	
	@FindBy(how=How.XPATH,using="//button[@class='close']")
	WebElement policyclose_button;
	
	@FindBy(how=How.XPATH,using="//li[text()='Click on validate signature']")
	WebElement instructiontab_text;
	
	
	
	public Form16Page(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyForm16TabDisplay() {
		//log("Form16 tab displayed and object is :"+ form16_tab.toString());
		return form16_tab.isDisplayed();
		
	}
	
//	public boolean verifyForm16TabSelected(){
//		TestUtil.clickByXpath(driver, form16_tab);
//		return form16_tab.isSelected();
//	}
	
	public boolean verifyInstructionTabDisplay(){
		//log("Instruction tab displayed and object is :"+ instruction_tab.toString());
		return instruction_tab.isDisplayed();
	}
	
//	public boolean verifyInstructionTabSelected(){
//		
//		return instruction_tab.isSelected();
//	}

	public void clickonInstructionTab(){
		
		TestUtil.clickByXpath(driver,  instruction_tab);
	}
	
	public void verifyPdfDownload() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		TestUtil.clickByXpath(driver, pdfdownload_link);
		//log("Cliked on Pdf_link and object is:-"+pdfdownload_link.toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void verifyLeftSpinner(){
		TestUtil.clickonSpinnerButton(leftspinner);
	}
	
	public void verifyRightSpinner(){
		TestUtil.clickonSpinnerButton(rightspinner);
	}
	
	
	public boolean verifyPolicyButton(){
		
		return policybutton.isDisplayed();
		
	}
	
	public void clickOnPolicyButton(){
		
		policybutton.click();
	}
	
	public String verifyTextonPolicySnippet(){
		
		return policysnippet.getText();
		
		
	}
	
public void clickOnPolicyCloseButton(){
		
		 policyclose_button.click();
		
	}
	
	public String verifyinstructionTabText(){
		
		return instructiontab_text.getText();
		
	}
	
	public void verifyEmailSent(){
		email_link.click();
	}

	

}
