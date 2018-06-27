//package com.investmentdec.qa.pages;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
//
//import com.investmentdec.qa.base.TestBase;
//import com.investmentdec.qa.utility.TestUtil;
//
//public class ServicesPage extends TestBase {
//	
//	
//	@FindBy(how=How.XPATH,using="//img[@title='my-courses']")
//	WebElement form16_image;
//	
//	
//	public ServicesPage(){
//		PageFactory.initElements(driver, this);
//	}
//	
//	
//	
//	public Form16Page clickOnForm16(){
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		form16_image.click();
//		return new Form16Page();
//	}
//
//	public boolean verifyForm16Link() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		TestUtil.clickByXpath(driver, form16_image);
//		return form16_image.isDisplayed();
//		
//	}
//	
//	
//	
//
//}
