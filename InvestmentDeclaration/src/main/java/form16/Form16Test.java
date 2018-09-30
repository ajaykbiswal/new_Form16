package form16;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Form16Test extends wait {
	public static WebDriver driver;
	public static  boolean str;
	public static  String str1;
	
	@Test
	public static void Form16TestCases() throws Exception   {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		 ChromeOptions options = new ChromeOptions();
//	        options.addArguments("window-size=475,1012");
//
//	        DesiredCapabilities cap = DesiredCapabilities.chrome();
//	        cap.setCapability(ChromeOptions.CAPABILITY, options);
//
//	        //this will open chrome with set size
//	         driver = new ChromeDriver(options);
//		
//		Dimension d = new Dimension(475,812);
//    	driver.manage().window().setSize(d);
		System.out.println(driver.manage().window().getSize());
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://webpages.centralindia.cloudapp.azure.com/");
		driver.findElement(By.id("username")).sendKeys("P10045300");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	
	Assert.assertTrue(driver.findElement(By.xpath("//i[@class='ico_home']")).isDisplayed());
	WebElement service=driver.findElement(By.xpath("//i[@class='ico_home']"));
		Assert.assertTrue(service.isDisplayed());
		Actions action=new Actions(driver);
		action.moveToElement(service).click().build().perform();
		Thread.sleep(8000);
		//WebElement myhr=driver.findElement(By.xpath("//a[@title='My HR' and @class='myhr']"));
		WebElement myhrs=driver.findElement(By.xpath("//a[@title='manage-attendance' and @class='myhr']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
js.executeScript("arguments[0].scrollIntoView(true);",myhrs );
//a[@title='manage-attendance' and @class='myhr']
		//WebElement myhr=driver.findElement(By.xpath("//a[@class='myhr' and @title='My HR']"));
		System.out.println(myhrs.isDisplayed());
		
//		WebElement myhrs=driver.findElement(By.xpath("///a[text()='My HR']"));
		
		
	//JavascriptExecutor js = (JavascriptExecutor) driver;
////		//js.executeScript("scroll(0,800)");
////	
////		
////		
////		
//		js.executeScript("arguments[0].scrollIntoView(true);",myhr );
//		
//		js.executeScript("arguments[0].click;",myhr );
//		myhrs.sendKeys(Keys.ARROW_DOWN);
//		myhrs.sendKeys(Keys.ENTER);
		//Thread.sleep(2000);
		//js.executeScript("scroll(0,-1100)");
	action.moveToElement(myhrs).click().build().perform();
	
//		WebElement form16=driver.findElement(By.xpath("//a[@class='ico-form-16' and @title='Form 16']"));
//		Assert.assertTrue(form16.isDisplayed());
//		action.moveToElement(form16).click().build().perform();
//		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-3']")).isDisplayed());
//		System.out.println("Form16 Tab displayed");
//		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-4']")).isDisplayed());
//		Thread.sleep(6000);
//		WebElement pdflink=driver.findElement(By.xpath("//img[@alt='pdf']"));
//		action.moveToElement(pdflink).click().build().perform();
      
//      WebElement newRequestTab=driver.findElement(By.xpath("//div[text()='New Request']"));
//       WebDriverWait wait = new WebDriverWait(driver, 25000); 
//       wait.until(ExpectedConditions.elementToBeClickable(newRequestTab));
		//wait.waitForPageToLoad(25);
        Thread.sleep(20000);
       WebElement category= driver.findElement(By.xpath("//button[@id='dd-category']"));
       action.moveToElement(category).click().build().perform();
	   List<WebElement> categoryList=driver.findElements(By.xpath("//div[@aria-labelledby='dd-category']//button"));
	   System.out.println(categoryList.size());
	   
	   for(WebElement categoryItems:categoryList){ 	   
		 try {
			if  ( categoryItems.getText().contentEquals("Benefits - Insurance12")){
				 
				 Assert.assertTrue(categoryItems.isSelected(),  " Select category :  is not found  in the list box");	
				 
				 break;
			 }
			 else {
				 
				 action.moveToElement( categoryItems).click().build().perform();
				 
					break;
				
			 }
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
			 
	   }
	   WebElement subCategory=driver.findElement(By.xpath("//button[@id='dd-sub-category']"));
	   action.moveToElement(subCategory).click().build().perform();
	   List<WebElement> subCategoryList=driver.findElements(By.xpath(" //div[@aria-labelledby='dd-sub-category']//button"));
	   System.out.println(subCategoryList.size());

	   for(WebElement subCategoryItems:subCategoryList){ 	   
		   System.out.println( subCategoryItems.getText());
	
			 if  (  subCategoryItems.getText().contentEquals("GHP- Group Hospital Policy - Claim")==true){
				 action.moveToElement(subCategoryItems).click().build().perform();
				 break;
			 }
			   
		   } 
	   
	   driver.findElement(By.name("subject")).sendKeys("want");
	   driver.findElement(By.name("description")).sendKeys("want");
	   WebElement attachbtn=driver.findElement(By.xpath("//button[contains(@class,'sign-green')]"));
	   js.executeScript("arguments[0].scrollIntoView(true);",attachbtn );
	   driver.findElement(By.xpath("//button[contains(@class,'sign-green')]")).click();
	   Runtime.getRuntime().exec("C:\\Attach\\FileUpload.exe");
	   Thread.sleep(2000);
	   WebElement e=driver.findElement(By.xpath(" //span[@class='attach-count']"));
	   
	   System.out.println(e.getText());
	   
	   System.out.println(e.getAttribute("text"));
	   
//	   driver.findElement(By.xpath("//button[text()='SAVE']")).click();
//	   System.out.println(driver.findElement(By.xpath("//span[contains(text(),'ID')]")).getText());
//	   driver.findElement(By.xpath("//button[text()='Close']")).click();
//	   
	   ////ul//li[text()='8000004975']
	 //span[@class='attach-count']
	   
	   
	   
	   
//	    for(int i=0;i<ele.size();i++){
//	    	System.out.println(ele.get(i).getText());
//	    
//	    	if(ele.get(i).getText().equals("Benefits - Insurance")==true){
//	    		action.moveToElement(ele.get(i)).click().build().perform();
//
//	    		break;
//	    		
//	    	}
	    	
//	    }
	   
       
       

	  
	   
//		while (true) {
//		     WebElement cancelButton = driver.findElement(By.xpath("//*[@id='ngb-tab-3-panel']/div/app-finyear-list/div/div/div/button[1]"));
//		     if (cancelButton.getAttribute("disabled")==null ) {
//		    	cancelButton.click();
//		    	Thread.sleep(1000);
//		    }    
//		    else {
//		        break;
//		    }
//		}
//
//		while (true) {
//		     WebElement cancelButton = driver.findElement(By.xpath("//*[@id='ngb-tab-3-panel']/div/app-finyear-list/div/div/div/button[2]"));
//		     if (cancelButton.getAttribute("disabled")==null ) {
//		    	cancelButton.click();
//		    	Thread.sleep(1000);
//		    }    
//		    else {
//		        break;
//		    }
//		}
		
		
//		driver.findElement(By.xpath("//a[@class='cta-doc']")).click();
//		WebElement ele=driver.findElement(By.xpath("//div[@class='policySnippet']"));
//         Thread.sleep(1000);
//		Assert.assertTrue(ele.getText().contains("Guidelines"));
//		driver.findElement(By.xpath("//button[@class='close']")).click();
//		
//		WebElement insttab=driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-4']"));
//		action.moveToElement(insttab).click().build().perform();
//		Thread.sleep(2000);
//		WebElement ele2=driver.findElement(By.xpath("//li[text()='Click on validate signature']"));
//		Assert.assertTrue(ele2.getText().contains("validate signature"));
//		Thread.sleep(2000);
		
	   		
		
		
		
	}
     
	
	
	
	
 
	 
	
	
	
	
	


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