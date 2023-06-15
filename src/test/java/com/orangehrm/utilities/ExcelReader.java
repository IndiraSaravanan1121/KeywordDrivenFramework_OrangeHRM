package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	String columnLocatorName;
	static String locatorName;
	static String locatorValue;
	String keywordColumnName;
	public static String dataColumnName;	
	int totalRowNum;

	/**
	 * This Method is to get xlsx file location and sheet name
	 * @param location
	 * @throws IOException
	 */
	public void getExcelLocation(String location) throws IOException {

		file = new FileInputStream(location);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
		totalRowNum = sheet.getLastRowNum();

	}

	/**
	 * This Method is to read locator, Keyword and test data
	 * @param row
	 * @param locatorColumn
	 * @param keywordColumn
	 * @param valueColumn
	 * @return
	 */
	public String readLocatorKeywordAndValue(int row, int locatorColumn, int keywordColumn, int valueColumn) {
		
		columnLocatorName = sheet.getRow(row).getCell(locatorColumn).toString().trim();
		if(!columnLocatorName.contains("NA")) {
		locatorName = columnLocatorName.split("=")[0].toString().trim();	
		locatorValue = columnLocatorName.split("=")[1].toString().trim();
		} else {
			locatorName = "NA";
			locatorValue = "NA";
		}
		keywordColumnName = sheet.getRow(row).getCell(keywordColumn).toString().trim();
		dataColumnName = sheet.getRow(row).getCell(valueColumn).toString().trim();
		return keywordColumnName;
	}
}

