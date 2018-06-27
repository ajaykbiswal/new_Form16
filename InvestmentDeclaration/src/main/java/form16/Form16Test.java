package form16;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Form16Test {
	public static WebDriver driver;
	public static  boolean str;
	public static  String str1;
	@Test
	public static void Form16TestCases() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://webpages.centralindia.cloudapp.azure.com/");
		driver.findElement(By.id("username")).sendKeys("P00403903");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class='ico_home']")).isDisplayed());
		WebElement service=driver.findElement(By.xpath("//i[@class='ico_services']"));
		Assert.assertTrue(service.isDisplayed());
		Actions action=new Actions(driver);
		action.moveToElement(service).click().build().perform();
		WebElement form16=driver.findElement(By.xpath("//a[@class='ico-form-16' and @title='Form 16']"));
		Assert.assertTrue(form16.isDisplayed());
		action.moveToElement(form16).click().build().perform();
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-3']")).isDisplayed());
		System.out.println("Form16 Tab displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-4']")).isDisplayed());
		Thread.sleep(6000);
//		WebElement pdflink=driver.findElement(By.xpath("//img[@alt='pdf']"));
//		action.moveToElement(pdflink).click().build().perform();
//		Thread.sleep(2000);

//        
       
       

	  
	   
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
		
		
		driver.findElement(By.xpath("//a[@class='cta-doc']")).click();
		WebElement ele=driver.findElement(By.xpath("//div[@class='policySnippet']"));
         Thread.sleep(1000);
		Assert.assertTrue(ele.getText().contains("Guidelines"));
		driver.findElement(By.xpath("//button[@class='close']")).click();
		
		WebElement insttab=driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='ngb-tab-4']"));
		action.moveToElement(insttab).click().build().perform();
		Thread.sleep(2000);
		WebElement ele2=driver.findElement(By.xpath("//li[text()='Click on validate signature']"));
		Assert.assertTrue(ele2.getText().contains("validate signature"));
		Thread.sleep(2000);
		
		
		
		
		
	}
     
	
	
	 
	
	
	
	
	}
