package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class HomePage extends BaseClass {

	ActionsClass action = new ActionsClass();
	@FindBy(xpath = "//i[@class=\"icon-heart\"]/following-sibling::span")
	WebElement Wishlist;

	@FindBy(xpath = "//span[text()=\"Order history and details\"]")
	WebElement OrderDetails;

	@FindBy(xpath = "//p[@class=\"info-account\"]")
	WebElement homepagetextCheck;

	public HomePage() {

		PageFactory.initElements(getDriver(), this);
	}

	public boolean ValidateWishlist() {

		action.fluentWait(getDriver(), Wishlist);

		return action.isDisplayed(Wishlist);

	}

	public boolean ValidateOrderDetails() {

		action.fluentWait(getDriver(), OrderDetails);
		return action.isDisplayed(OrderDetails);

	}

	public String homePageCheck() {

		action.fluentWait(getDriver(),homepagetextCheck);

		return action.textGet(homepagetextCheck);

	}
}
