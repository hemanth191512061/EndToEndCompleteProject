package com.mystore.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendManager {

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static ExtentTest test;

	public static void extendReport() throws IOException {
		// TODO Auto-generated method stub

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\reports.html");

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "MyHost");

		extent.setSystemInfo("Project Name", "MyStore");

		extent.setSystemInfo("Tester", "Hemanth");

		extent.setSystemInfo("OS", "Windows10");

		extent.setSystemInfo("Browser", "chrome");
		// calling flush writes everything to the log file
		
	}
	
	public static void endReport() {
		
		
		extent.flush();
	}
}
