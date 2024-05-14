package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class ApparelPage extends BaseClass{
	
	public ApparelPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class=\"listbox\"]//ul/li/a[@href=\"/shoes\"]") WebElement shoesUnderCategoryList;
	@FindBy(xpath="//div[@class=\"listbox\"]//ul/li/a[@href=\"/apparel\"]") WebElement apparelUnderCategoryList;
	
	public void clickOnShoesUnderCategoryList()
	{
		click(driver,shoesUnderCategoryList);
	}
	public Boolean  apparelIsDisplayedOrNot()
	{
		Boolean status=isDisplayed(driver,apparelUnderCategoryList);
		return status;
		
	}
	
}
