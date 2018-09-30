package form16;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Testbases {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest childnode;
	
	@BeforeSuite
	public void startReport(){
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml"));
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		//extent.setAnalysisStrategy(AnalysisStrategy.CLASS);

		extent.setSystemInfo("Host Name", "LT0088970");
		extent.setSystemInfo("Environment", "QA - Automation");
		extent.setSystemInfo("User Name", "Ajay Biswal");
		htmlReporter.config().setDocumentTitle("HRaas-Automation");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
//		String[] header = new String[] { "HeaderA", "HeaderB", "HeaderC" };
//		List list = new ArrayList();
//		list.add(new String[] { "cell1", "cell2", "cell3" });
//		list.add(new String[] { "cell4", "cell5", "cell6" });
		
	
		
	
		
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
    	 // extent.log(LogStatus.INFO, "HTML", "Usage: BOLD TEXT");
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " - Test Case Skiped", ExtentColor.CYAN));
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skiped", ExtentColor.CYAN));
      }
		
	}
	
	@AfterSuite
	public void endReport(){
		extent.flush();
		
	}
	 

}
