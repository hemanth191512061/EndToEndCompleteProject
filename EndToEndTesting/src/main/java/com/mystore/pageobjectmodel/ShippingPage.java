package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class ShippingPage extends BaseClass {

	ActionsClass action = new ActionsClass();
	
	@FindBy(id="cgv")
	WebElement check;
	
	@FindBy(xpath="//button//span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutPage;
	
	public ShippingPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver, this);
		
	}
	
	public void checkBox() throws InterruptedException {
		
		action.Click(Driver, check);
	}
	
	public PaymentsPage clickOnProceed() throws InterruptedException {
		
		action.Click(Driver, checkOutPage);
		
		return new PaymentsPage();
	}
}
