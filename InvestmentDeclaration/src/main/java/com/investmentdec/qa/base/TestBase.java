package com.investmentdec.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.investmentdec.qa.utility.TestUtil;


public class TestBase {
	
	public static WebDriver driver; 
 	public static Properties pro; 
 	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

 
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
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_waitTime, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		Thread.sleep(5000);
	
	}
	
	@BeforeSuite
	public void startReport(){
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "LT0088970");
		extent.setSystemInfo("Environment", "QA - Automation");
		extent.setSystemInfo("User Name", "Ajay Biswal");
		
		htmlReporter.config().setDocumentTitle("HRaas-Automation");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml"));
		
	}
   @AfterMethod
	public void getResult(ITestResult result) throws IOException{
		
      if(result.getStatus()==ITestResult.FAILURE){
    	  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " - Test Case Failed", ExtentColor.RED));
    	  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "", ExtentColor.RED));
    	 // String screenshotName=TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
    	//  logger.fail("Screenshot of the Failed Test Case").addScreenCaptureFromPath(screenshotName);
//    	  logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
      }
      else if(result.getStatus() == ITestResult.SUCCESS){
    	  logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " - Test Case Passed", ExtentColor.GREEN));
      }
 
      else if(result.getStatus() == ITestResult.SKIP){
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " - Test Case Skiped", ExtentColor.YELLOW));
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skiped", ExtentColor.YELLOW));
      }
		
	}
	
	@AfterSuite
	public void endReport(){
		extent.flush();
		
	}
	
	
	
	
	
	
	
	
	
	
}
