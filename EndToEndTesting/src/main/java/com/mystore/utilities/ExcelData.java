/**
 * 
 */
package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author welcome
 *
 */
public class ExcelData {

	FileInputStream file;

	XSSFWorkbook book;

	Sheet sheet;

	Row row;

	Cell cell;

	public static int rowCount;
	
	public static int cellCount;

	public  static LinkedHashSet<String> array = new LinkedHashSet<String>();

	
	
	public void getData() throws IOException {

		file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\LoginDeatils.xlsx");

		book = new XSSFWorkbook(file);

		sheet = book.getSheet("Credentials");

		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		System.out.println("lastrow "+ sheet.getLastRowNum());
		
		System.out.println("Firstrow "+sheet.getFirstRowNum());

		for (int i = 1; i <= rowCount; i++) {

			row = sheet.getRow(i);
			
			cellCount= row.getLastCellNum()-row.getFirstCellNum();
			
			System.out.println("lastCell "+ row.getLastCellNum() );
			
			System.out.println("FirstCell "+row.getFirstCellNum());
			

			for (int j = 0; j < cellCount; j++) {

				CellType type = row.getCell(j).getCellType();

				if (type == CellType.NUMERIC) {

					int d = (int) row.getCell(j).getNumericCellValue();

					String password = Integer.toString(d);

					array.add(password);

				}

				else if (type == CellType.STRING) {

					array.add(row.getCell(j).getStringCellValue());
				}

				// array.add(row.getCell(j).getStringCellValue());

			}

			//System.err.println(array.toString());
		}


	}

}
