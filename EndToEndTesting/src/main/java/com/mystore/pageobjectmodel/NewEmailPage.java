package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class NewEmailPage extends BaseClass {

	ActionsClass action = new ActionsClass();
	
	@FindBy(xpath="//h1[text()=\"Create an account\"]")
	WebElement CreateAccountTextCheck;
	
	public NewEmailPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean AccoutTestCheck() {
		
		return action.isDisplayed(CreateAccountTextCheck);
	}
	
	
	
}
