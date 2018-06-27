package com.investmentdec.qa.utility;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.investmentdec.qa.base.TestBase;

public class TestUtil extends TestBase {
	

	public static long Implicity_waitTime=20;
	public static long Page_Load_Timeout=80;
	
	public static FileInputStream files;
	public static PDFParser parser;
	public static COSDocument cosdoc;
	public static PDDocument pddoc;
	public static PDFTextStripper striper;
	
	
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
				   }else{
					   System.out.println("Delete Operation is Failed");
				   }
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}	 
	
}
	
	
}
