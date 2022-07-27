package com.mystore.pageobjectmodel;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class IndexPage extends BaseClass {

	ActionsClass action = new ActionsClass();

	@FindBy(xpath = "//a[@class=\"login\"]")
	public WebElement Login;

	@FindBy(id = "search_query_top")
	public WebElement searchText;

	@FindBy(name = "submit_search")
	public WebElement Search;

	@FindBy(xpath = "//img[contains(@class,\"img-responsive\")]")
	public WebElement logo;

	public IndexPage() {
		// TODO Auto-generated constructor stub
		//Driver = base.lanchBrowser();

		PageFactory.initElements(getDriver(), this);

	}

	public SignPage signIn() throws InterruptedException {

		// action.fluentWait(Driver,Login);

		action.Click(getDriver(), Login);

		return new SignPage();

	}

	public boolean logoSearch() {

		return action.isDisplayed(logo);
	}

	public String title() {

		return getDriver().getTitle();
	}

	public SearchPage searchBox(String object) throws InterruptedException {

		action.sendthekeys(searchText, object);

		Thread.sleep(2000);

		action.Click(getDriver(), Search);

		return new SearchPage();
	}

}
