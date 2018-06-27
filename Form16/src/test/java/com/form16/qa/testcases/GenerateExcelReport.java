package com.form16.qa.testcases;

import org.testng.annotations.Test;

import com.form16.qa.utility.Xl;

public class GenerateExcelReport {

	@Test
	public void Report() throws Exception{
		
		Xl.generateReport("excel-report.xlsx");
	}
}
