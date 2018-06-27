package com.investmentdec.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.investmentdec.qa.base.TestBase;
import com.investmentdec.qa.utility.TestUtil;


public class HomePage extends TestBase {
	
	@FindBy(how=How.XPATH,using="//i[@class='ico_home']")
	WebElement userHome_label;
	
	@FindBy(how=How.XPATH,using="//i[@class='ico_services']")
	WebElement services_label;
	
	@FindBy(how=How.XPATH,using="//a[@class='ico-form-16' and @title='Form 16']")
	WebElement form16_image;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	
	public boolean verifyHomelabel(){
		
		return userHome_label.isDisplayed();
		
	}
	
	public boolean verifyServicelabel(){
		
		return services_label.isDisplayed();
		
	}
	
	public void clickOnServices(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.clickByXpath(driver, services_label);
		
		
	}
	
	public boolean verifyForm16Title(){
		
		return form16_image.isDisplayed();
		
		
	}
	
	public Form16Page clickOnForm16(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.clickByXpath(driver, form16_image);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new Form16Page();
	}
	
}
