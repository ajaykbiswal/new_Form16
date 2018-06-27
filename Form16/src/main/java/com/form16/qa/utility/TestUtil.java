package com.form16.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.common.function.type4.Parser;
import org.apache.pdfbox.util.PDFTextStripper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.form16.qa.base.TestBase;

public class TestUtil extends TestBase {
	

	public static long Implicity_waitTime=20;
	public static long Page_Load_Timeout=20;
	
	public static String DataFilePath=" ";
	
	public static FileInputStream files;
	public static PDFParser parser;
	public static COSDocument cosdoc;
	public static PDDocument pddoc;
	public static PDFTextStripper striper;
	public static Workbook book;
	public static Sheet sheet;

	
	

	public static  void clickByXpath(WebDriver ldriver,WebElement lxpath){
		Actions action=new Actions(ldriver);
		action.moveToElement(lxpath).click().build().perform();
	}

	public static String verifyPdfFile() {
		String data = "";
			try {
				files=new FileInputStream(new File(pro.getProperty("PdffileName")));
				parser=new PDFParser(files);
				parser.parse();			
				cosdoc=parser.getDocument();
				pddoc=new PDDocument(cosdoc);
				striper=new PDFTextStripper();
				data = striper.getText(pddoc);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
			
	}
	
public static void deleteFileOperation(){
		   
		try {
			File file=new File(pro.getProperty("PdfFile"));
			File[] files=file.listFiles();
			 for(File f:files){
				   if(f.getName().endsWith(".pdf")){
					   f.delete();
					   System.out.println(f.getName() + "is Deleted!..."+ "");
					   break;
				   }
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}	 
	
}

	
public static Object[][] getTestdata(String sheetName){
		
		FileInputStream ofile=null;
		try {
			 ofile=new FileInputStream(DataFilePath); 
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(ofile);
		} 
		catch (InvalidFormatException e) {	
			e.printStackTrace();
		} 
		catch (IOException e) {	
			e.printStackTrace();
		}
		
		sheet=book. getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		System.out.println(sheet.getLastRowNum());
//		System.out.println(sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++){
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
//				System.out.println(data[i][j]);
			
			}
		}
		return data;
	
}
	
	
public static  String takeScreenshotAtEndOfTest(WebDriver driver,String screenshotName){
			String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcfile=ts.getScreenshotAs(OutputType.FILE);
			String destfile=System.getProperty("user.dir")+"/failedTestsScreenshots/"+ screenshotName+dateName+System.currentTimeMillis() + ".png";
			try {
				
				FileUtils.copyFile(srcfile,new File(destfile));
		   } catch (IOException e) {
				
				e.printStackTrace();
			}
			return destfile;
	
}

public static void getScreenshotAtEndOfTest() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
				try {
						FileUtils.copyFile(srcfile,new File(currentdir + "/screenshots/"+ System.currentTimeMillis() + ".png")); 
			    } catch (IOException e) {
				       e.printStackTrace();	 
	            }

}

	public static void explicity_WaitTime(WebElement element, int timeToWaitInSec) { 
		 	WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec); 
		 	wait.until(ExpectedConditions.visibilityOf(element)); 
	} 
	
	public static void clickonSpinnerButton(WebElement element){
		
		while (true) {
		     if (element.getAttribute("disabled")==null ) {
		    	 element.click();    	
		    }    
		    else {
		        break;
		    }
		}
}
	
	
	
	
	
}
	
	
	
	
	
	

