package com.baseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends BaseController {

	@BeforeMethod
	public void beforeMethod() {
		Initialization();
	}

	@AfterMethod
	public void afterMethod() {
		teardown();
	}

}