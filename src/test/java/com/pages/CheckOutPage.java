package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class CheckOutPage extends BaseClass{
public CheckOutPage()
{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//input[@id=\"BillingNewAddress_FirstName\"]") WebElement firstname;
@FindBy(xpath="//input[@id=\"BillingNewAddress_LastName\"]") WebElement lastname;
@FindBy(xpath="//input[@id=\"BillingNewAddress_Email\"]") WebElement email;
@FindBy(xpath="//input[@id=\"BillingNewAddress_Company\"]") WebElement company;
@FindBy(xpath="//*[@name=\"BillingNewAddress.CountryId\"]") WebElement country;
@FindBy(xpath="//*[@name=\"BillingNewAddress.City\"]") WebElement city;
@FindBy(xpath="//*[@id=\"BillingNewAddress_Address1\"]") WebElement address1;
@FindBy(xpath="//*[@id=\"BillingNewAddress_ZipPostalCode\"]") WebElement zip;
@FindBy(xpath="//*[@id=\"BillingNewAddress_PhoneNumber\"]") WebElement phoneNumber;
@FindBy(xpath="//*[@id=\"save-billing-address-button\"]/following-sibling::button") WebElement continueButton;
@FindBy(xpath="//*[@name=\"BillingNewAddress.StateProvinceId\"]") WebElement state;
@FindBy(xpath="//*[@class=\"button-1 shipping-method-next-step-button\"]") WebElement shippingMethodContinue;
@FindBy(xpath="//*[@class=\"button-1 payment-method-next-step-button\"]") WebElement paymentmethodContinue;
@FindBy(xpath="//*[@class=\"button-1 payment-info-next-step-button\"]") WebElement paymentInfoContinue;
@FindBy(xpath="//*[@class=\"button-1 confirm-order-next-step-button\"]") WebElement confirmOrderbutton;
@FindBy(xpath="//*[text()=\"Your order has been successfully processed!\"]") WebElement title;


public void fillBillingAddressDetails()
{
	type(firstname,"name1");
	type(lastname,"last");
	type(email,"name1@email.com");
	selectByVisibleText("United States",country);
	selectByVisibleText("AE (Armed Forces Europe)",state);
	type(city,"florida");
	type(address1,"myaddress");
	type(zip,"123456");
	type(phoneNumber,"1234567890");
	click(driver,continueButton);
	click(driver,shippingMethodContinue);
	click(driver,paymentmethodContinue);
	click(driver,paymentInfoContinue);
	click(driver,confirmOrderbutton);
	
	
}
public String getSuccessMsg()
{
	return getText(title);
}
}
