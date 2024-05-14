package com.controllerInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ControllerInterface {

	//Created abstract methods for all user action
	public boolean click(WebDriver driver, WebElement element);
	public boolean isDisplayed(WebDriver driver, WebElement element);
	public boolean type(WebElement element, String text);
	public boolean isSelected(WebDriver driver, WebElement element);
	public boolean isEnabled(WebDriver driver, WebElement element);
	public boolean selectByIndex(WebElement element, int index);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement element);
	public boolean switchToFrameByIndex(WebDriver driver,int index);
	public boolean switchToFrameById(WebDriver driver,String idValue);
	public boolean switchToFrameByName(WebDriver driver,String nameValue);
	public boolean switchToDefaultFrame(WebDriver driver);
	public void moveToElement(WebDriver driver,WebElement element);
	public void rightclick(WebDriver driver,WebElement element);
	public void Alert(WebDriver driver);
	public String getTitle(WebDriver driver);
	public String getCurrentURL(WebDriver driver);
	public String getText(WebElement element);

}