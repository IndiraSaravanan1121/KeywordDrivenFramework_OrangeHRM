package com.orangehrm.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.orangehrm.LoginOrangeHrm;

public class KeywordDriven {
	
	ExcelReader readExcel = new ExcelReader();
	Method[] methods;
	String excelKeyword;
	LoginOrangeHrm methodKeyword;
	
	@Test
	public void readAndWriteExcelFile() throws Exception {
		
		int locatorColumn = 3;
		int keywordColumn = 4;
		int dataColumn = 5;
		
		readExcel.getExcelLocation(".//src//test//resources//orangeHRMKeywords.xlsx");		
		
		for(int row=1; row<=readExcel.totalRowNum;row++) {
			excelKeyword = readExcel.readLocatorKeywordAndValue(row, locatorColumn, keywordColumn, dataColumn);
			executeKeywords();
		}
	}	
	
	public KeywordDriven () {
		methodKeyword = new LoginOrangeHrm();	
		methods = methodKeyword.getClass().getMethods();
	}
	
	public void executeKeywords() throws Exception {
		
		for (int i=0; i<methods.length;i++) {
			if(methods[i].getName().equalsIgnoreCase(excelKeyword)) {
				methods[i].invoke(methodKeyword);
			}
		}
	}
}
