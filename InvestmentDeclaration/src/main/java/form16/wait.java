package form16;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class wait {
	
	static WebDriver driver;
	JavascriptExecutor js;
	
	public static void waitForPageToLoad(long timeOutInSeconds) { 
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() { 
			
 			public Boolean apply(WebDriver driver) {  
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"); 
				
			} 
 		};
		try { 
 			System.out.println("Waiting for page to load..."); 
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
 			wait.until(expectation); 
		} catch (Throwable error) { 
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds"); 
 			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete."); 

 
		} 
	} 
	
  

}
