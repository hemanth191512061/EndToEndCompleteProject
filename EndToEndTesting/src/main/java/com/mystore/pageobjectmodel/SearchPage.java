package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class SearchPage extends BaseClass {
	ActionsClass action = new ActionsClass();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement Product;
	
	public SearchPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver, this);
		
	}
	
	public boolean productIsDisplayed() {
		
		return action.isDisplayed(Product);
	}
	
	public AddToCartPage productClick() throws InterruptedException {
		
		action.Click(Driver, Product);
		
		return new AddToCartPage();
	}
		
	
	
}
