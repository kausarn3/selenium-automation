package com.zohocrm.testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DriverManager extends Keywords {
	static ArrayList data;
	static DriverManager dm = new DriverManager();

	static {
		try {
			data = new ArrayList();
			FileInputStream file = new FileInputStream("F://Files//models.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getCellTypeEnum() == CellType.STRING) {
						data.add(cell.getStringCellValue());
					}
					if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						data.add(cell.getNumericCellValue());
					}
					if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
						data.add(cell.getBooleanCellValue());
					}

				}
			}

		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals("Leads") && data.get(i + 1).equals("yes")) {
				try {
					ArrayList data1 = new ArrayList();
					FileInputStream file = new FileInputStream("F://Files//testcase.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.iterator();
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							if (cell.getCellTypeEnum() == CellType.STRING) {
								data1.add(cell.getStringCellValue());
							}
							if (cell.getCellTypeEnum() == CellType.NUMERIC) {
								data1.add(cell.getNumericCellValue());
							}
							if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
								data1.add(cell.getBooleanCellValue());
							}
						}

					}

					for (int j = 0; j < data1.size(); j++) {
						if (data1.get(j).equals("Openbrowser")) {
							String Keywordname = (String) data1.get(j);
							String testData = (String) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testData + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {

								dm.openbrowser();
							}

						}
						if (data1.get(j).equals("Navigate")) {
							String Keywordname = (String) data1.get(j);
							String testData = (String) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testData + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {

								dm.navigate(testData);

							}
						}
						if (data1.get(j).equals("input")) {
							String Keywordname = (String) data1.get(j);
							String testData = (String) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testData + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {

								dm.input(testData, objectname);

							}
						}
						if (data1.get(j).equals("click")) {
							String Keywordname = (String) data1.get(j);
							String testData = (String) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testData + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {

								dm.signIn(objectname);

							}
						}
						if (data1.get(j).equals("waitStatement")) {
							String Keywordname = (String) data1.get(j);
							double testData = (double) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testData + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {

								dm.waitStatement(testData);

							}
						}
						if (data1.get(j).equals("salutation")) {
							String Keywordname = (String) data1.get(j);
							String testdata = (String) data1.get(j + 1);
							String objectname = (String) data1.get(j + 2);
							String runMode = (String) data1.get(j + 3);
							System.out.println(Keywordname + " " + testdata + " " + objectname + " " + runMode);
							if (runMode.equals("yes")) {
								dm.salutation(testdata);

							}
						}

					}

				} catch (Exception e) {

				}

			}
		}

	}

}
