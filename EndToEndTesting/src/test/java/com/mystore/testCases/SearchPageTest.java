/**
 * 
 */
package com.mystore.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.SearchPage;

/**
 * @author welcome
 *
 */
public class SearchPageTest extends BaseClass {

	IndexPage index;

	SearchPage searchPage;

	@Parameters("browser")
	@BeforeClass(groups = { "Sanity", "Smoke", "Regression" })
	public void launchBrowser(String Browser) throws IOException, InterruptedException {

		congifTest();

		Thread.sleep(2000);

		lanchBrowser(Browser);

	}

	@AfterClass(groups = { "Sanity", "Smoke", "Regression" })
	public void quitBrowser() {

		closeBrowser();

	}

	@Test(priority = 1, groups = "Smoke")
	public void searchTheObject() throws InterruptedException {

		index = new IndexPage();

		searchPage = index.searchBox("t-shirt");

		System.out.println("t shirt object is searched");

	}

	@Test(priority = 2, groups = "Smoke")
	public void productAvailabilityCheck() {

		boolean value = searchPage.productIsDisplayed();

		Assert.assertTrue(value);

		System.out.println("Product is available");

	}

}
