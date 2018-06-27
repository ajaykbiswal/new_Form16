package com.form16.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.form16.qa.base.TestBase;
//import com.form16.qa.utility.TestUtil;



public class LoginPage extends TestBase {
	
	//public static final Logger log=Logger.getLogger(LoginPage.class.getName());
	
	//Page factory or OR
	
	@FindBy(how=How.ID,using="username")
	WebElement userID;
	
	@FindBy(how=How.ID,using="password")
	WebElement password;
	
	@FindBy(how=How.ID,using="submit")
	WebElement login_btn;
	
	@FindBy(how=How.XPATH,using="//span[text()='HR SERVICES']")
	WebElement hrservice_logo;
	
	@FindBy(how=How.XPATH,using="//i[@class='ico_home']")
	WebElement userHome_label;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
    //Actions
	
	public String verifyLoginPageTitle() {
       
		
		return driver.getTitle();
		
			
	}
      
	

	public boolean verifyHRservicelogo(){
		
		
		return hrservice_logo.isDisplayed();	
		
	}
	
	public HomePage login(String user,String pass){
		
		
		userID.sendKeys(user);
		
//		log("Entered password:-"+pass+" and object is "+password.toString());
		password.sendKeys(pass);
		
		login_btn.click();
		
		return new HomePage();
	}

	
	
}
