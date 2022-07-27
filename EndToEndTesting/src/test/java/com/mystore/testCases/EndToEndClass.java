/**
 * 
 */
package com.mystore.testCases;

import static org.testng.Assert.assertTrue;

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
import com.mystore.pageobjectmodel.AddToCartPage;
import com.mystore.pageobjectmodel.AddressPage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.OrderConfirmationPage;
import com.mystore.pageobjectmodel.OrderPage;
import com.mystore.pageobjectmodel.OrderSummaryPage;
import com.mystore.pageobjectmodel.PaymentsPage;
import com.mystore.pageobjectmodel.SearchPage;
import com.mystore.pageobjectmodel.ShippingPage;
import com.mystore.pageobjectmodel.SignPage;

/**
 * @author welcome
 *
 */
public class EndToEndClass extends BaseClass {

	IndexPage index;

	SearchPage searchPage;

	AddToCartPage addToCart;

	OrderPage orderPage;

	SignPage signIn;

	AddressPage addressPage;

	ShippingPage shippingPage;

	PaymentsPage paymentPage;

	OrderSummaryPage orderSummeryPage;

	OrderConfirmationPage orderConfimationPage;

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

	@Test(priority = 1, groups = "Regression")
	public void searchTheObject() throws InterruptedException {

		index = new IndexPage();

		searchPage = index.searchBox("t-shirt");

		System.out.println("t shirt object is searched");

	}

	@Test(priority = 2, groups = "Regression")
	public void productClick() throws InterruptedException {

		addToCart = searchPage.productClick();

		System.out.println("Product is available");

		System.out.println("Clicked on the tshirt");

	}

	@Test(priority = 3, groups = "Regression")
	public void addProductToCart() throws InterruptedException {

		addToCart.quantitySelect("2");

		addToCart.sizeSelect("M");

		addToCart.addToCartSelect();

	}

	@Test(priority = 4, groups = "Regression")
	public void proceedToCheckoutPageAfterClickingAddToCart() throws InterruptedException {

		orderPage = addToCart.proceedToOrderPage();

		signIn = orderPage.checkToProceed();

	}

	@Test(priority = 5, groups = "Regression")
	public void signInToPage() throws InterruptedException {

		addressPage = signIn.SubmitLoginPageDetails2(prop.getProperty("username").trim(),
				prop.getProperty("password").trim());

	}

	@Test(priority = 6, groups = "Regression")
	public void addressPageProceed() throws InterruptedException {

		shippingPage = addressPage.clickOnCheckOut();

	}

	@Test(priority = 7, groups = "Regression")
	public void shippingPageCheckProceed() throws InterruptedException {

		shippingPage.checkBox();

		paymentPage = shippingPage.clickOnProceed();

	}

	@Test(priority = 8, groups = "Regression")
	public void paymentPageOptionProceed() throws InterruptedException {

		orderSummeryPage = paymentPage.clickPayByCheck();

		orderConfimationPage = orderSummeryPage.clickOnConfirmOrder();

		boolean result = orderConfimationPage.checkOrderisConfirmed();

		Assert.assertTrue(result);

	}

}
