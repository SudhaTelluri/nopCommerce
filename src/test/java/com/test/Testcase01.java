package com.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pages.Page;

public class Testcase01 extends BaseClass {
	Page page;

	@BeforeMethod
	public void setup() {
		page = new Page();
	}

	@Test()
	public void test_ComputersTab()  {
		page.getURL();
		page.clickComputerTab();
	}
}
