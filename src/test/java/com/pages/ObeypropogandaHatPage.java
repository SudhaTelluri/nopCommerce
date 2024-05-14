package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class ObeypropogandaHatPage extends BaseClass {
	
	public ObeypropogandaHatPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="product_attribute_13") WebElement sizeDropdown;
	@FindBy(xpath="//*[text()=\"Add to cart\"]") WebElement addToCart;
	@FindBy(xpath="//a[text()=\"shopping cart\"]") WebElement notificationShoppingCart;
	
	public void selectingSizeOption()
	{
		selectByVisibleText("Small",sizeDropdown);
	}
	public void clickOnAddToCart()
	{
		moveToElement(driver,addToCart);
	}
	public void clickOnShoppingCartOfNotificationBar()
	{
		click(driver,notificationShoppingCart);
	}

}
