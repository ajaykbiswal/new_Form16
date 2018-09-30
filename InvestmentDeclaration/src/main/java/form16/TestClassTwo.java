package form16;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestClassTwo extends Testbases {

	
	@Test
    public void testMethod4()
    {
		logger=extent.createTest("testMethod4");
     Assert.assertTrue(true);
    }
     
    @Test
    public void testMethod5()
    {
    	logger=extent.createTest("testMethod5");
     Assert.assertTrue(false);
    }
     
    @Test
    public void testMethod6()
    {
    	logger=extent.createTest("testMethod6");
     throw new SkipException("Skipped Intentionally");
    }
	
}
