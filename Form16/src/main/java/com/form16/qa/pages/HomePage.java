package com.form16.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.form16.qa.base.TestBase;
import com.form16.qa.utility.TestUtil;



public class HomePage extends TestBase {
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
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
			//log("Home Screen displayed and object is :"+ userHome_label.toString());
			return userHome_label.isDisplayed();
		
	}
	
	public boolean verifyServicelabel(){
		       
				//log("Service Label displayed and object is :"+ services_label.toString());
				return services_label.isDisplayed();
		
	}
	
	public void clickOnServices(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		TestUtil.clickByXpath(driver, services_label);
		//log("Cliked on Service and object is:-"+services_label.toString());
		
		
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
