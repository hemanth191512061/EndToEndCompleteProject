package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class SignPage extends BaseClass {

	ActionsClass action = new ActionsClass();

	@FindBy(id = "email")
	WebElement email;

	@FindAll({ @FindBy(id = "passwd"), @FindBy(name = "passwd") })
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement submit;

	@FindBy(id = "email_create")
	WebElement NewEmail;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;

	public SignPage() {

		// base.lanchBrowser("chrome");
		PageFactory.initElements(getDriver(), this);

	}

	public HomePage SubmitLoginPageDetails(String username, String Password) throws InterruptedException {

		action.fluentWait(getDriver(), email);

		action.sendthekeys(email, username);

		Thread.sleep(2000);
		
		action.sendthekeys(password, Password);

		Thread.sleep(2000);

		action.Click(getDriver(), submit);

		Thread.sleep(2000);

		return new HomePage();

	}

	public AddressPage SubmitLoginPageDetails2(String username, String Password) throws InterruptedException {

		action.Scroll(getDriver(), email);

		Thread.sleep(2000);

		action.sendthekeys(email, username);

		Thread.sleep(2000);

		action.sendthekeys(password, Password);

		Thread.sleep(2000);

		action.Click(getDriver(), submit);

		Thread.sleep(2000);

		return new AddressPage();

	}

	public NewEmailPage NewEmailCreation(String Email) throws InterruptedException {

		action.sendthekeys(NewEmail, Email);

		action.Click(getDriver(), SubmitCreate);

		return new NewEmailPage();

	}

}
