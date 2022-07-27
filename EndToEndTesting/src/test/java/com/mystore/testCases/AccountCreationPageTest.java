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
import com.mystore.pageobjectmodel.NewEmailPage;
import com.mystore.pageobjectmodel.SignPage;

public class AccountCreationPageTest extends BaseClass {

	IndexPage index;

	SignPage signInPage;

	NewEmailPage newEmailPage;

	@Parameters("browser")
	@BeforeClass(groups = { "Sanity", "Smoke", "Regression" })
	public void launchBrowser(String Browser) throws IOException, InterruptedException {

		congifTest();

		Thread.sleep(2000);

		lanchBrowser(Browser);

	}

	@Test(priority = 1, groups = "Sanity")
	public void loginTest() throws InterruptedException {

		index = new IndexPage();

		Thread.sleep(2000);

		signInPage = index.signIn();

		Thread.sleep(2000);

		System.out.println("In the sign in page");

	}

	@Test(priority = 2, groups = "Sanity")
	public void signIn() throws Exception {

		Thread.sleep(2000);

		newEmailPage = signInPage.NewEmailCreation("abedsfgge12345@gmail.com");

		Thread.sleep(2000);

		System.out.println("In New Mail page");

	}

	@Test(priority = 3, groups = "Sanity")

	public void newMailPageCheck() throws InterruptedException {

		Thread.sleep(2000);

		boolean flag = newEmailPage.AccoutTestCheck();

		Thread.sleep(2000);

		Assert.assertTrue(flag);

		System.out.println("On New mail creation page");

	}

	@AfterClass(groups = { "Sanity", "Smoke", "Regression" })
	public void quitBrowser() {

		closeBrowser();

	}
}
