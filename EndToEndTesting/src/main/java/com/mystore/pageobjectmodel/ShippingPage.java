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
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public void checkBox() throws InterruptedException {
		
		action.Click(getDriver(), check);
	}
	
	public PaymentsPage clickOnProceed() throws InterruptedException {
		
		action.Click(getDriver(), checkOutPage);
		
		return new PaymentsPage();
	}
}
