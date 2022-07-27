package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class AddressPage extends BaseClass {

	ActionsClass action = new ActionsClass();
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement checkout;
	
	public AddressPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public ShippingPage clickOnCheckOut() throws InterruptedException {
		
		action.Click(getDriver(), checkout);
		return new ShippingPage();
	}
}
