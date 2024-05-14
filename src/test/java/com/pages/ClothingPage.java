package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseClass.BaseClass;

public class ClothingPage extends BaseClass {
	WebDriverWait wait;
	public ClothingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="products-pagesize") WebElement display;
	@FindBy(className="product-title") List<WebElement> totalProducts;
	@FindBy(xpath="//a[contains(@class,'viewmode-icon grid')]") WebElement gridView;
	@FindBy(xpath="//a[contains(@class,'viewmode-icon list selected')]") WebElement listView;
	
	
	
	public int checkProductsDisplayPerPage() throws InterruptedException
	{
		click(driver,display);
		
		selectByVisibleText("3",display);
	
			//Thread.sleep(4000);
		return totalProducts.size();
	}
	
	public WebElement getGridView()
	{
		return gridView;
	}

	public WebElement getListView()
	{
		return listView;
	}

	
	
	
}
