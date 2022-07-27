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
import org.w3c.dom.DOMConfiguration;

import com.logger.log.Loggers;
import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.DataProviderClass;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.SignPage;

public class LoginPageTest extends BaseClass {

	IndexPage index;

	SignPage signInPage;

	public  HomePage homePage;

	// DataProviderClass dataProvide= new DataProviderClass();

	@Parameters("browser")
	@BeforeTest(groups = { "Sanity", "Smoke", "Regression" })
	public void launchBrowser(String Browsers) throws IOException, InterruptedException {

		Loggers.info("Configuration of properties file");

		congifTest();

		Thread.sleep(2000);

		Loggers.info("Launching the brower");

		lanchBrowser(Browsers);

	}

	@Test(priority = 1, groups = { "Sanity", "Smoke" })
	public void loginTest() throws InterruptedException, IOException {

		Loggers.info("In Index page");

		index = new IndexPage();

		signInPage = index.signIn();

		Loggers.info("In sign in page");

		// dataProvide.userData();

	}

	@Test(priority = 2, dataProvider = "Credentials", dataProviderClass = DataProviderClass.class, groups = { "Sanity",
			"Smoke" })
	public void signIn(String Username, String Password) throws Exception {

		homePage = signInPage.SubmitLoginPageDetails(Username, Password);

		Loggers.info("Login details submitted");

		System.out.println("Logged into the account");

	}

	@Test(priority = 3, groups = { "Sanity", "Smoke" })
	public void currentURLChecking() throws InterruptedException {

		String actualText = homePage.homePageCheck();

		Assert.assertEquals(actualText,
				"Welcome to your account. Here you can manage all of your personal information");

		Loggers.info("Entered in the home page");

	}

	@AfterTest(groups = { "Sanity", "Smoke", "Regression" })
	public void quitBrowser() throws InterruptedException {

		Thread.sleep(2000);

		closeBrowser();

		Loggers.info("Quiting the browsers");

	}

}
