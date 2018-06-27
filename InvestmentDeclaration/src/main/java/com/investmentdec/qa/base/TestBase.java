package com.investmentdec.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.investmentdec.qa.utility.TestUtil;


public class TestBase {
	
	public static WebDriver driver; 
 	public static Properties pro; 

 
	public TestBase(){ 
 		 
 		try { 
 			pro=new Properties(); 
			FileInputStream ofile=new FileInputStream("C:\\HRaas-Payroll_Automation\\Form16\\src\\main\\java\\com\\form16\\qa\\config\\config.properties"); 
 			pro.load(ofile); 
 		} catch (FileNotFoundException e) { 
 			 e.getMessage(); 
		} catch (IOException e) { 
 			 
 			e.getMessage();
 		} 
	} 

	public static void initialization() throws Exception{
		
		String browserName=pro.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", pro.getProperty("chromdriver"));
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firfox")){
			
			System.setProperty("webdriver.chrome.driver", pro.getProperty(""));
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.chrome.driver", pro.getProperty(""));
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_waitTime, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		Thread.sleep(5000);
	
	}
	
}
