//package com.form16.qa.utility;
//
//import java.io.File;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.form16.qa.base.TestBase;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ExtentTest;

//public class ExtentReportListener extends TestBase implements ITestListener {
//	public static ExtentReports extent;
//    public static ExtentTest logger;
//
//	public void onTestStart(ITestResult result) {
//	
//		logger=extent.startTest(result.getMethod().getMethodName());
//		logger.log(LogStatus.INFO, result.getMethod().getMethodName() +" "+ " is Started");
//	
//}


//public void onTestSuccess(ITestResult result) {
//	
//	logger.log(LogStatus.PASS, result.getMethod().getMethodName() +" "+ " is Passed");
//
//	
//}
//
//
//public void onTestFailure(ITestResult result) {
//	logger.log(LogStatus.FAIL, result.getMethod().getMethodName() +" "+ " is Failed");
//	logger.log(LogStatus.FAIL, result.getThrowable());
//	
//	
//	String screenshotName=TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
//	logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotName));
//
//
//}
//
//
//public void onTestSkipped(ITestResult result) {
//	
//		logger.log(LogStatus.SKIP, result.getMethod().getMethodName() + " "+  " is skipped");
//
//}
//
//
//public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//	
//}
//
//
//public void onStart(ITestContext context) {
//
//	System.out.println("on start");
//	extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//	extent.addSystemInfo("Selenium Version", "2.53");
//	extent.addSystemInfo("Environment", "QA");
//extent.loadConfig(new File(System.getProperty("user.dir")+"src\\main\\resources\\extent-config.xml"));
//    
//
//	
//}
//
//
//public void onFinish(ITestContext context) {
//	
//	System.out.println("Passed tests: " + context.getPassedTests());
//	System.out.println("Failed tests: " + context.getFailedTests());
//	extent.endTest(logger);
//	extent.flush();
//	//driver.get("C:\\HRaas-Payroll_Automation\\Form16\\test-output\\ExtentReport.html");
//	//driver.close();
//}
//
//
//}

