package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class PaymentsPage extends BaseClass {
	ActionsClass action = new ActionsClass();

	@FindBy(xpath = "//a[@class=\"bankwire\"]")
	WebElement payByBankWire;

	@FindBy(xpath = "//a[@class=\"cheque\"]")
	WebElement payByCheck;

	public PaymentsPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(Driver, this);
	}

	public OrderSummaryPage clickPayByBankWire() throws InterruptedException {

		action.Click(Driver, payByBankWire);

		return new OrderSummaryPage();
	}

	public OrderSummaryPage clickPayByCheck() throws InterruptedException {

		action.Click(Driver, payByCheck);

		return new OrderSummaryPage();
	}
}
