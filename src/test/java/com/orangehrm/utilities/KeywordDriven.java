package com.orangehrm.utilities;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.orangehrm.LoginOrangeHrm;
import com.orangehrm.constants.Constants;

public class KeywordDriven {
	
	ExcelReader readExcel = new ExcelReader();
	Method[] methods;
	String excelKeyword;
	LoginOrangeHrm methodKeyword;
	Locators locators;
	static By value;
	
	@Test
	public void readAndWriteExcelFile() throws Exception {
		
		readExcel.getExcelLocation(Constants.EXCEL_LOCATION);		
		
		for(int row=1; row<=readExcel.totalRowNum;row++) {
			excelKeyword = readExcel.readLocatorKeywordAndValue(row, Constants.LOCATORS_COLUMN, Constants.ACTION_KEYWORDS_COLUMN, Constants.TESTDATA_COLUMN);
			findLocators();
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
	
	public static By findLocators() {
		switch(ExcelReader.locatorName) {
		case Constants.ID:
			value = Locators.getId(ExcelReader.locatorValue);
			break;
		case Constants.NAME:
			value = Locators.getName(ExcelReader.locatorValue);
			break;
		case Constants.XPATH:
			value = Locators.getXpath(ExcelReader.locatorValue);
			break;
		case Constants.CLASSNAME:
			value = Locators.getClassName(ExcelReader.locatorValue);
			break;
		}
		return value;
	}

}
