package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;

public class NewEmailPage extends ActionsClass {

	ActionsClass action = new ActionsClass();
	
	@FindBy(xpath="//h1[text()=\"Create an account\"]")
	WebElement CreateAccountTextCheck;
	
	public NewEmailPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(Driver, this);
		
	}
	
	public boolean AccoutTestCheck() {
		
		return action.isDisplayed(CreateAccountTextCheck);
	}
	
	
	
}
