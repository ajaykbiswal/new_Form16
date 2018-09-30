package form16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApiTest {
	
	
	
	    public static FileInputStream fis = null;
	    public static FileOutputStream fos = null;
	    public static Workbook book;
		public static Sheet sheet;
	    public static Row row ;
	    public static Cell cell;
	    String xlFilePath;
	    public static String DataFilePath="C:\\Users\\ajay1.biswal\\Desktop\\TestData.xlsx ";
	 
//	    public ExcelApiTest(String xlFilePath) throws Exception
//	    {
//	        this.xlFilePath = xlFilePath;
//	        fis = new FileInputStream(xlFilePath);
//	        book = new XSSFWorkbook(fis);
//	        fis.close();
//	    }
	 
	    public static boolean setCellData(String sheetName, int rowNum , int colNumber, String value)
	    { 
	    	
	    	
	    	try {
				//this.xlFilePath = xlFilePath;
				fis = new FileInputStream(new File(DataFilePath));
				book = new XSSFWorkbook(fis);
				fis.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
	        try
	        {
	            sheet = book.getSheet(sheetName);
	            row = sheet.getRow(rowNum);
	            if(row==null)
	                row = sheet.createRow(rowNum);
	 
	            cell = row.getCell(colNumber);
	            if(cell == null)
	                cell = row.createCell(colNumber);
	 
	            cell.setCellValue(value);
	 
	            fos = new FileOutputStream(DataFilePath);
	            book.write(fos);
	            fos.close();
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	            return  false;
	        }
	        return true;
	    }
	}


