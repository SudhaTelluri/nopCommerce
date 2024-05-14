package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseClass.BaseClass;

public class ShoesPage extends BaseClass {
	
	public ShoesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="products-orderby") WebElement sortBy;
	@FindBy(xpath="//*[text()=\"Name: A to Z\"]") WebElement productsInAscendingOrder;
	@FindBy(className="product-title") List<WebElement> listOfElements;
	WebDriverWait wait;
	
	
	public WebElement getsortBy()
	{
		return sortBy;
	}
	
	public List<WebElement>  getListOfElements()
	{
		return listOfElements;
	}
	
	
	public List getTemp() 
	{
		click(driver,sortBy);
		List actualList=new ArrayList();
		for(WebElement ele:listOfElements)
		{
			String data=ele.getText();
			actualList.add(data);
			
		}
		List temp=new ArrayList();
		temp=actualList;
		Collections.reverse(temp);
		return temp;
	}
	
	public List getZToA() throws InterruptedException
	{
		
		click(driver,sortBy);
		Select select=new Select(sortBy);
		select.selectByVisibleText("Name: Z to A");
		List reverseList=new ArrayList();
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfElements));
		for(WebElement ele:listOfElements)
		{
			String data=ele.getText();
			reverseList.add(data);
		}
		return reverseList;
	
	}
	

}
