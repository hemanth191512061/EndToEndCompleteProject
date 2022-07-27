/**
 * 
 */
package com.mystore.dataprovider;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.mystore.utilities.ExcelData;

/**
 * @author welcome
 *
 */
public class DataProviderClass extends ExcelData {

	// ExcelData excelData= new ExcelData();

	// @DataProvider(name="Credentials")

	@DataProvider(name = "Credentials")
	public Object[][] userData() throws IOException {

		getData();

		Iterator<String> iter = array.iterator();

		Object[][] userPass = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				if (iter.hasNext()) {
					userPass[i][j] = iter.next();
					System.out.println(userPass[i][j]);

				}
			}
		}
		return userPass;

	}

}
