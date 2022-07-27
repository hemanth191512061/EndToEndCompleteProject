package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class OrderPage extends BaseClass {

	ActionsClass action = new ActionsClass();
	@FindBy(xpath = "//span[@class=\"price\"]/span")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;

	public OrderPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver, this);

	}

	public double unitPriceCheck() {

		String unitValue = unitPrice.getAttribute("value");
		
		System.out.println("Value is"+unitValue);

		String trimmedValue = unitValue.replaceAll("[^a-zA-Z0-9]", "");

		 Double d=Double.parseDouble(trimmedValue);
		 
		 return d/100;
	}

	public double totalPriceCheck() {

		String totalValue = totalPrice.getText();

		String trimmedValue = totalValue.replaceAll("[^a-zA-Z0-9]", "");

		Double d=Double.parseDouble(trimmedValue);
		
		return d/100;
	}

	public SignPage checkToProceed() throws InterruptedException {

		action.Click(Driver, proceedToCheckOut);

		return new SignPage();
	}

}
