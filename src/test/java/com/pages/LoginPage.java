package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;
import com.utility.Log;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordEle;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement submit;
	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	WebElement errorMessage;

	@FindBy(xpath="//*[text()=\"Checkout as Guest\"]")
	WebElement checkOutAsGuest;

	public void loginApplication(String email, String password) {
		driver.get(loginURL);
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		click(driver, submit);
		Log.logInfo("Click on Login Button");
		Log.logInfo(driver.getCurrentUrl());

	}
	public String getErrorMessage() {
		Log.logInfo(getText(errorMessage));
		return getText(errorMessage);
	}

	public void goToLoginPage() {
		driver.get(loginURL);
		Log.logInfo("We are in Login Page");
		Log.logInfo(driver.getCurrentUrl());
	}
	public void clickOnCheckOutAsGuest()
	{
		click(driver,checkOutAsGuest);
	}
}
