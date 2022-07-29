package com.mystore.actiondrivers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.baseclass.BaseClass;

public class ActionsClass extends BaseClass {

	public void Click(WebDriver Driver, WebElement clicking) throws InterruptedException {

		// Thread.sleep(2000);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", clicking);

		Actions act = new Actions(Driver);

		act.moveToElement(clicking).click().build().perform();

		// clicking.click();

	}

	public void sendthekeys(WebElement sendingText, String text) throws InterruptedException {

		Thread.sleep(2000);

		sendingText.clear();

		sendingText.sendKeys(text);
	}

	public void waiting(WebDriver Driver, By waits) {

		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(waits));

	}

	public void fluentWait(WebDriver Driver, WebElement ele) {

		// Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(Driver);
		// Specify the timout of the wait
		wait.withTimeout(Duration.ofSeconds(20));
		// Sepcify polling time
		wait.pollingEvery(Duration.ofSeconds(5));
		// Specify what exceptions to ignore
		wait.ignoring(Exception.class);

		// This is how we specify the condition to wait on.
		// This is what we will explore more in this chapter
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectByIndex(WebElement Selecting, int index) {

		Select sel = new Select(Selecting);

		sel.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement Selecting, String text) {

		Select sel = new Select(Selecting);

		sel.selectByVisibleText(text);

	}

	public void Scroll(WebDriver Driver, WebElement scrolling) {

		JavascriptExecutor je = (JavascriptExecutor) Driver;

		je.executeScript("arguments[0].scrollIntoView(true);", scrolling);

	}

	public void JSClick(WebDriver Driver, WebElement element) {

		JavascriptExecutor je = (JavascriptExecutor) Driver;

		je.executeScript("arguments[0].click();", element);

	}

	public void implicitWait(WebDriver Driver, int Seconds) {

		Driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
	}

	public void pageLoadTimeOut(WebDriver Driver, int Seconds) {

		Driver.manage().timeouts().pageLoadTimeout(Seconds, TimeUnit.SECONDS);
	}

	public boolean isDisplayed(WebElement Display) {

		return Display.isDisplayed();
	}

	public String textGet(WebElement text) {

		return text.getText();

	}

	public String screenshot(String Filename) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMdhhmmss").format(new Date());
		
		String FilePath;

		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file,

				new File(System.getProperty("user.dir") + "\\ScreenShot\\" + Filename  + dateName + ".png"));
		
		FilePath="http://localhost:8080/job/MyStore/ws/EndToEndTesting/Screenshot/" + Filename + dateName + ".png";
		
		return FilePath;

	}
}
