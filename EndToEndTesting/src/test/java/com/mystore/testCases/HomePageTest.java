package com.mystore.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.SignPage;

public class HomePageTest extends BaseClass {

	IndexPage index;

	SignPage signInPage;

	HomePage homePage;

	@Parameters("browser")
	@BeforeClass(groups = { "Sanity", "Smoke", "Regression" })
	public void launchBrowser(String Browser) throws IOException, InterruptedException {

		congifTest();

		Thread.sleep(2000);

		lanchBrowser(Browser);

	}

	@Test(priority = 1, groups = "Smoke")
	public void loginTest() throws InterruptedException {

		index = new IndexPage();
		
		Thread.sleep(5000);

		signInPage = index.signIn();

	}

	@Test(priority = 2, groups = "Smoke")
	public void signIn() throws Exception {

		homePage = signInPage.SubmitLoginPageDetails(prop.getProperty("username").trim(),
				prop.getProperty("password").trim());

		System.out.println("Logged into the account");

	}

	@Test(priority = 3, groups = "Smoke")
	public void currentURLChecking() throws InterruptedException {

		boolean flag = homePage.ValidateWishlist();

		Assert.assertTrue(flag);

		boolean flag2 = homePage.ValidateOrderDetails();

		Assert.assertTrue(flag2);

	}

	@AfterClass(groups = { "Sanity", "Smoke", "Regression" })
	public void quitBrowser() {

		closeBrowser();

	}

}
