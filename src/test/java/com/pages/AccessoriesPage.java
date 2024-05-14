package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class AccessoriesPage extends BaseClass {

	
	public AccessoriesPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[text()=\"Add to cart\"]/../../..//a[text()=\"Obey Propaganda Hat\"]") WebElement addToCart;
	@FindBy(xpath="//*[@data-productid=\"33\"]//*[text()=\"Add to cart\"]") WebElement raybanAddToCart;
	@FindBy(xpath="//a[text()=\"shopping cart\"]") WebElement shoppingCart;
	public void clickOnAddToCart()
	{
		moveToElement(driver,addToCart);
	}
	public void clickOnRaybanAddToCart()
	{
		moveToElement(driver,raybanAddToCart);
	}
	public void clickOnShoppingCart()
	{
		click(driver,shoppingCart);
	}
}
