package com.form16.qa.utility;

//import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.form16.qa.base.TestBase;
//import com.relevantcodes.extentreports.ExtentTest;


public class WebEventListeners  extends TestBase implements WebDriverEventListener{


//	public static ExtentTest logger;

	
	public void beforeNavigateTo (String url, WebDriver driver) {
		
		//System.out.println("Before navigating to: '" + url + "'"); 
	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		
		//System.out.println("Navigating to: '" + url + "'"); 
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	
		System.out.println("Value of the:" + element.toString() + " before any changes made"); 
				
	}

	public void afterChangeValueOf(WebElement element, WebDriver arg1) {
		
	System.out.println("Element value changed to: " + element.toString()); 
		
	}
   
	public void beforeClickOn(WebElement element, WebDriver driver) {
//    	   System.out.println("Trying to click on: " + element.toString()); 
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString()); 
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page"); 
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("Navigated back to previous page"); 
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Navigating forward to next page"); 
	}
	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page"); 
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Just before beforeScript " + driver);
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("Just after afterScript " + driver);
		
	}
	
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("Found Element By : " + by.toString());
		
		
		
		
	}
	
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error.getMessage()); 
			
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}


	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}
 
//	public void log(String data){
//	
//		 log.info(data);
//		 Reporter.log(data);
//  	 logger.log(LogStatus.INFO, data);
//	 
//	}




}
