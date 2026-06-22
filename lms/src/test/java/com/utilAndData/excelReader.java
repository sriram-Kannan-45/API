package com.utilAndData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelReader {
	@DataProvider(name = "invalidEmail")
	public Object[][] invalidEmail() throws IOException {

	    return getExcelData(
	            "src/test/resources/data.xlsx",
	            "Sheet1");
	}

	@DataProvider(name = "invalidPassword")
	public Object[][] invalidPassword() throws IOException {

	    return getExcelData(
	            "src/test/resources/data.xlsx",
	            "Sheet2");
	}

	@DataProvider(name = "withoutdata")
	public Object[][] withoutdata() throws IOException {

	    return getExcelData(
	            "src/test/resources/data.xlsx",
	            "Sheet3");
	}

	@DataProvider(name = "getAllNotes")
	public Object[][] getAllNotes() throws IOException {

	    return getExcelData(
	            "src/test/resources/data.xlsx",
	            "Sheet4");
	}

	@DataProvider(name = "blankOptions")
	public Object[][] blankOptions() throws IOException {

	    return getExcelData(
	            "src/test/resources/data.xlsx",
	            "Sheet5");
	}

	@SuppressWarnings("resource")
	private Object[][] getExcelData(String filePath, String sheetName) {

		Object[][] data = null;

		try {

			System.out.println("File Path : " + new File(filePath).getAbsolutePath());

			FileInputStream fis = new FileInputStream(filePath);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			System.out.println("Available Sheets:");

			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

				System.out.println(workbook.getSheetName(i));
			}

			XSSFSheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {

				throw new RuntimeException("Sheet not found : " + sheetName);
			}

			int rows = sheet.getPhysicalNumberOfRows();

			XSSFRow headerRow = sheet.getRow(0);

			int cols = headerRow.getLastCellNum();

			data = new Object[rows - 1][cols];

			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i < rows; i++) {

				XSSFRow row = sheet.getRow(i);

				if (row == null) {

					for (int j = 0; j < cols; j++) {

						data[i - 1][j] = "";
					}

					continue;
				}

				for (int j = 0; j < cols; j++) {

					Cell cell = row.getCell(j);

					data[i - 1][j] = cell == null ? "" : formatter.formatCellValue(cell);
				}
			}

			workbook.close();
			fis.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

}
