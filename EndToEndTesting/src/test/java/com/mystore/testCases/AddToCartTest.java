/**
 * 
 */
package com.mystore.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjectmodel.AddToCartPage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.SearchPage;

/**
 * @author welcome
 *
 */
public class AddToCartTest extends BaseClass {

	IndexPage index;

	SearchPage searchPage;

	AddToCartPage addToCart;

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

	@Test(priority = 1, groups = { "Regression", "Sanity" })
	public void searchTheObject() throws InterruptedException {

		index = new IndexPage();

		searchPage = index.searchBox("t-shirt");

		System.out.println("t shirt object is searched");

	}

	@Test(priority = 2, groups = { "Regression", "Sanity" })
	public void productClick() throws InterruptedException {

		boolean value = searchPage.productIsDisplayed();

		Assert.assertTrue(value);

		System.out.println("Product is available");

		addToCart = searchPage.productClick();

		System.out.println("Clicked on the tshirt");

	}

	@Test(priority = 3, groups = { "Regression", "Sanity" })
	public void addProductToCart() throws InterruptedException {

		addToCart.quantitySelect("2");

		addToCart.sizeSelect("M");

		addToCart.addToCartSelect();

		Boolean result = addToCart.checkProductAddedToCart();

		// Assert.assertEquals(result, "Product successfully added to your shopping
		// cart");

		Assert.assertTrue(result);

		System.out.println("Selected the size and quantity and clicked on add to cart");

	}
}
