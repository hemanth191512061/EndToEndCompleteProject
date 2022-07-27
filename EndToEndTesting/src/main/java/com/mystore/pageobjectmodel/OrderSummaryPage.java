package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class OrderSummaryPage extends BaseClass {
	
	ActionsClass action = new ActionsClass();
	@FindBy(xpath="//span[contains(text(),\"I confirm my\")]")
	WebElement confirmOrder;
	
	public OrderSummaryPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(Driver, this);
	}
	
	
	public OrderConfirmationPage clickOnConfirmOrder() throws InterruptedException {
		
		action.Click(Driver, confirmOrder);
		
		return new OrderConfirmationPage(); 
		
	}
	

}
