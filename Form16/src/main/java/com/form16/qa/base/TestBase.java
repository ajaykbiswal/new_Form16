package com.form16.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.form16.qa.utility.TestUtil;
import com.form16.qa.utility.WebEventListeners;
import com.form16.qa.utility.Xl;
//import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	
	public static WebDriver driver; 
 	public static Properties pro; 
 	public static EventFiringWebDriver fireEventdriver;
 	public static WebEventListeners eventlisteners;
 	public static Logger log=Logger.getLogger(TestBase.class.getName());
 	public static ExtentTest test;
 	
 	
 
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

	public static void initialization(){
		
		
		String browserName=pro.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", pro.getProperty("chromdriver"));
			log.info(" Browser is initialized ");
			driver=new ChromeDriver();
			log.info("Creating object of :" + pro.getProperty("browser"));
		}else if(browserName.equalsIgnoreCase("firfox")){
			
			System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriverPath"));
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriverPath"));
			driver=new FirefoxDriver();
		}
		
		
		fireEventdriver=new EventFiringWebDriver(driver);
		eventlisteners=new WebEventListeners();
		fireEventdriver.register(eventlisteners);
		driver=fireEventdriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_waitTime, TimeUnit.SECONDS);
		log.info("Navigating to : "+ pro.getProperty("url"));
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_waitTime, TimeUnit.SECONDS);
		String log4jConfPath=System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	
	}

	@AfterClass(alwaysRun=true)
    public void teardown() throws Exception{
		Thread.sleep(4000);
    	driver.quit();
    	log.info(" Browser is closed ");
    }
		
//	public void log(String data){
//				log.info(data);
//				Reporter.log(data);
//				test.log(LogStatus.INFO, data);
//				
//	}
	
//	@AfterSuite
//public void generateReport() throws Exception{
//	
//	for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects())
//	{
//	    project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
//	}
//   Thread.sleep(10000);
//	Xl.generateReport("excel-report.xlsx");
//		
//	}
	
}
