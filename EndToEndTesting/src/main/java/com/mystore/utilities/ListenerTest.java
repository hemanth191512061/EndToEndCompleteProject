package com.mystore.utilities;

import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondrivers.ActionsClass;

public class ListenerTest extends ExtendManager implements ITestListener {

	ActionsClass action = new ActionsClass();

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub

		String FilePath;

		if (Result.getStatus() == ITestResult.FAILURE) {

			System.out.println("The name of the testcase failed is :" + Result.getName());
			try {
			test.log(Status.FAIL, MarkupHelper.createLabel(Result.getName() + "TestCase is failed", ExtentColor.RED));

			test.log(Status.FAIL,
					MarkupHelper.createLabel(Result.getThrowable() + "TestCase is failed", ExtentColor.RED));

			

				FilePath = action.screenshot(Result.getName());

				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(FilePath).build());

			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub

		if (Result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, Result.getName() + " Is skipped from Execution");

		}

	}

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub

		test = extent.createTest(Result.getName());

		test.createNode(Result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub

		if (Result.isSuccess()) {

			test.log(Status.PASS, "Name of the test passed is:" + Result.getName());
		}

	}

}
