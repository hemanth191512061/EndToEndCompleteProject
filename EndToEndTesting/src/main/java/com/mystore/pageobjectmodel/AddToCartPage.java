package com.mystore.pageobjectmodel;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionsClass;
import com.mystore.baseclass.BaseClass;

public class AddToCartPage extends BaseClass {

	
	ActionsClass action = new ActionsClass();
	@FindBy(id = "quantity_wanted")
	WebElement Quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()=\"Add to cart\"]")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement checkProductAdded;

	By path = By.xpath("//i[@class=\\\"icon-ok\\\"]/following-sibling::text()");

	@FindBy(xpath = "//span[contains(text(),\"Proceed to \")]")
	WebElement proceedToNextPage;

	public AddToCartPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver, this);

	}

	public void quantitySelect(String quant) throws InterruptedException {

		action.sendthekeys(Quantity, quant);

	}

	public void sizeSelect(String size1) {

		action.selectByVisibleText(size, size1);

	}

	public void addToCartSelect() throws InterruptedException {

		action.Click(Driver, addToCart);

	}

	public Boolean checkProductAddedToCart() throws InterruptedException {

		action.fluentWait(Driver, checkProductAdded);

		return action.isDisplayed(checkProductAdded);

	}

	public OrderPage proceedToOrderPage() {

		action.fluentWait(Driver,proceedToNextPage);
		
		action.JSClick(Driver, proceedToNextPage);

		return new OrderPage();

	}

}
