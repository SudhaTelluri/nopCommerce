package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=\"Apparel \"]") WebElement apparelLink;
	@FindBy(xpath="//*[text()=\" Apparel \"]/../..") WebElement apparelInCategory;
	@FindBy(xpath="//ul[@class=\"top-menu notmobile\"]//ul/li/a[@href=\"/shoes\"]") WebElement shoesUnderAppareltopmenu;
	@FindBy(xpath="//ul[@class=\"top-menu notmobile\"]//ul/li/a[@href=\"/clothing\"]") WebElement clothingUnderAppareltopmenu;
	@FindBy(xpath="//ul[contains(@class,\"top-menu notmobile\")]//ul//li/a[@href=\"/accessories\"]") WebElement accessoriesUnderAppareltopmenu;
	
	public void clickOnApparel()
	{
		driver.get(baseURL);
		click(driver,apparelLink);
		
	}
	public void clickOnApparelInCategory()
	{
		driver.get(baseURL);
		click(driver,apparelInCategory);
		
	}
	public void clickOnShoesUnderApparelOnHeaderMenu()
	{
		driver.get(baseURL);
		Actions actions=new Actions(driver);
		actions.moveToElement(apparelLink).build().perform();;
		click(driver,shoesUnderAppareltopmenu);
		
	}
	
	public void clickOnClothingUnderApparelOnHeaderMenu()
	{
		driver.get(baseURL);
		Actions actions=new Actions(driver);
		actions.moveToElement(apparelLink).build().perform();;
		click(driver,clothingUnderAppareltopmenu);
		
	}
	
	public void clickOnAccessoriesUnderApparelOnHeaderMenu()
	{
		driver.get(baseURL);
		Actions actions=new Actions(driver);
		actions.moveToElement(apparelLink).build().perform();;
		click(driver,accessoriesUnderAppareltopmenu);
		
	}
}
