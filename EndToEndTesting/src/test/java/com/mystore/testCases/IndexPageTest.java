package com.mystore.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjectmodel.IndexPage;

public class IndexPageTest extends BaseClass {

	
	public static IndexPage index;
	
	
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

	@Test(groups = "Smoke")
	public void logoCheck() {
		
		index=new IndexPage();
		
		boolean flag=index.logoSearch();
		
		Assert.assertTrue(flag);
		
	}
	
	
	@Test(groups = "Smoke")
	private void titleCheck() {
		// TODO Auto-generated method stub
		
		
		String actualTitle=index.title();
		
		Assert.assertEquals(actualTitle, "My Store");

	}
	
	
}
