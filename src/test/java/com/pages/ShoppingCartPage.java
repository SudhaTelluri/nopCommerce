package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;


public class ShoppingCartPage extends BaseClass {

	public ShoppingCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class=\"cart\"]//a[text()=\"Obey Propaganda Hat\"]") WebElement obeyPropagandaHat;
	@FindBy(xpath="//table[@class=\"cart\"]/tbody/tr//td[@class=\"quantity\"]") WebElement quantity;
	@FindBy(xpath="//*[text()=\"Update shopping cart\"]") WebElement updateShoppingCart;
	@FindBy(xpath="//table[@class=\"cart\"]/tbody/tr//td[@class=\"subtotal\"]") WebElement productSubTotal;
	@FindBy(xpath="//*[text()=\"Continue shopping\"]") WebElement continueShopping;
	@FindBy(xpath="//table[@class=\"cart\"]//a[text()=\"Ray Ban Aviator Sunglasses\"]") WebElement raybanAviatorSunglasses;
	@FindBy(id="termsofservice") WebElement termsOfService;
	@FindBy(xpath="//*[@name=\"checkout\"]") WebElement checkOutButton;
	public WebElement getObeyPropagandaHat()
	{
		return obeyPropagandaHat;
	}
	
	public String textInProductSubTotal()
	{
		return getText(productSubTotal);
	}
	
	public void updateQuantity() throws InterruptedException
	{
		Actions actions=new Actions(driver);
	actions
	.click(quantity)
	
	.sendKeys(Keys.CONTROL,"a",Keys.DELETE)
	.sendKeys(quantity,"3")
	.build().perform();
	click(driver,updateShoppingCart);
	}
	public void clickOnContinueShopping()
	{
		click(driver,continueShopping);
	}
	
	public WebElement getRaybanAviatorSunglasses()
	{
		return raybanAviatorSunglasses;
	}
	public void clickOnTermsOfService()
	{
		click(driver,termsOfService);
	}
	public void clickOnCheckOut()
	{
		moveToElement(driver,checkOutButton);
	}
	
	
	
}
