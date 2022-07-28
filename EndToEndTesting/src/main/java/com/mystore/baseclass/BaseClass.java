package com.mystore.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.X509ExtendedTrustManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.utilities.ExtendManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ActionsClass action;

	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public void congifTest() throws IOException {

		prop = new Properties();

		action = new ActionsClass();

		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir")+"/EndToEndTesting/Configuration/Config.properties");

		prop.load(input);

		
		ExtendManager.extendReport();
		
		
		// lanchBrowser();
		// setProperty();

	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void lanchBrowser(String browserName) {

		// String browserName= prop.getProperty("Driver");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}

		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();

		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("url"));

	}

	public static void setProperty() throws FileNotFoundException {

		OutputStream out = new FileOutputStream(
				System.getProperty("user.dir")+"\\Configuration\\Config.properties");

		prop.setProperty("Driver", "firefox");

		try {
			prop.store(out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeBrowser() {

		getDriver().quit();
		 
		ExtendManager.endReport();
		
	}

}
