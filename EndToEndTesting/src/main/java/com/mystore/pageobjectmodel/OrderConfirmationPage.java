package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	ActionsClass action = new ActionsClass();

	@FindBy(xpath = "//p[contains(@class,\"alert-success\")]")
	WebElement orderConfirm;

	public OrderConfirmationPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver, this);
	}

	public boolean checkOrderisConfirmed() {

		action.fluentWait(Driver, orderConfirm);

		return action.isDisplayed(orderConfirm);
	}
}
