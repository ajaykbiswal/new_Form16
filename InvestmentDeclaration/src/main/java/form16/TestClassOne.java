package form16;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestClassOne extends Testbases {
	
	

	
	@Test
    public void testMethodOne()
    {
		
		logger=extent.createTest("testMethodOne");
		logger.log(Status.INFO, "Starting loginPageTitleTest");
	  
		logger.log(Status.INFO, "Page of the Title is:"+  "HR Services");
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Title of the Page Verified Sucessfully");
		
    }
     
    @Test
    public void testMethodtwo()
    {
    	
    	logger=extent.createTest("testMethodtwo");
    	logger.log(Status.INFO, "Starting loginPageTitleTest");
    	logger.log(Status.INFO, "Page of the Title is:"+  "HR Services");
        Assert.assertTrue(false,"TestMethodtwo failed");
        //Assert.assertFalse(false, "TestMethodtwo failed");
        logger.log(Status.INFO, "Title of the Page Not Verified Sucessfully");
    }
     
    @Test
    public void testMethodthird()
    {
    	
    	logger=extent.createTest("testMethodthird");
    	logger.log(Status.INFO, "Starting loginPageTitleTest");
    	logger.log(Status.INFO, "Page of the Title is:"+  "HR Services");
    	
     throw new SkipException("Skipped Intentionally");
     
    }
	
}
