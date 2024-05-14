package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pages.AccessoriesPage;
import com.pages.ApparelPage;
import com.pages.CheckOutPage;
import com.pages.ClothingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ObeypropogandaHatPage;
import com.pages.ShoesPage;
import com.pages.ShoppingCartPage;

public class Apparel extends BaseClass {
	
	HomePage homePage;
	ApparelPage apparelPage;
	ShoesPage shoesPage;
	ClothingPage clothingPage;
	AccessoriesPage accessoriesPage;
	ObeypropogandaHatPage obeypropogandaHatPage;
	ShoppingCartPage shoppingCartPage;
	LoginPage loginPage;
	CheckOutPage checkOutPage;
	
	
@BeforeMethod
public void setup()
{
	homePage=new HomePage();
	apparelPage = new ApparelPage();
	shoesPage=new ShoesPage();
	clothingPage=new ClothingPage();
	accessoriesPage=new AccessoriesPage();
	obeypropogandaHatPage=new ObeypropogandaHatPage();
	shoppingCartPage=new ShoppingCartPage();
	loginPage=new LoginPage();
	checkOutPage=new CheckOutPage();
	}

@Test(groups= {"Apparel","Apparel_on_HomePage"},priority=1)
public void second_ApparelClickableOrNot()
{
	homePage.clickOnApparel();
	Assert.assertEquals(getTitle(driver), "nopCommerce demo store. Apparel");
}

@Test(groups= {"Apparel","Apparel_on_HomePage"},priority=2)
public void third_ApparelInCategory() 
{
	homePage.clickOnApparelInCategory();
	Assert.assertEquals(getTitle(driver), "nopCommerce demo store. Apparel");
}

@Test(groups= {"Apparel","Apparel_Under_Category"},priority=3)
public void fourth_ApparelUnderCategoryListOrNot()
{
	homePage.clickOnApparel();
	Assert.assertTrue(apparelPage.apparelIsDisplayedOrNot());
}

@Test(groups= {"Apparel","Shoes"},priority=4)
public void fifth_ApparelUnderCategoryListOrNot()
{
	homePage.clickOnShoesUnderApparelOnHeaderMenu();
	Assert.assertTrue(apparelPage.apparelIsDisplayedOrNot());
}
@Test(groups= {"Apparel","Shoes"},priority=5)
public void sixth_ShoesInApparelUnderCategoryGrid()
{
	homePage.clickOnShoesUnderApparelOnHeaderMenu();
	Assert.assertTrue(apparelPage.apparelIsDisplayedOrNot());
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Shoes"},priority=6)
public void Seventh_ShoesUnderCategoryOnLeftSideOfPage() throws InterruptedException
{
	
	homePage.clickOnShoesUnderApparelOnHeaderMenu();
	Assert.assertEquals(getTitle(driver), "nopCommerce demo store. Shoes");
	
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Shoes"},priority=7)
public void eighth_VerifySortingOrderOfShoes() throws InterruptedException
{
	
	homePage.clickOnShoesUnderApparelOnHeaderMenu();
	Assert.assertEquals( shoesPage.getTemp(), shoesPage.getZToA());       ;
	
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Clothing"},priority=8)
public void ninth_VerfiyApparelClothingDisplayperpage() throws InterruptedException
{
	homePage.clickOnClothingUnderApparelOnHeaderMenu();
	int noOfItemsDisplayedPerPage=clothingPage.checkProductsDisplayPerPage();
	Assert.assertEquals(noOfItemsDisplayedPerPage, 3);
	
}
@Test(groups= {"Apparel","Apparel_on_HomePage","Clothing"},priority=9)
public void tenth_VerifyApparelClothingGrid()
{
	homePage.clickOnClothingUnderApparelOnHeaderMenu();
	clothingPage.getGridView();
	Assert.assertTrue(clothingPage.getGridView().getAttribute("class").contains("selected"),"Grid View not selected");
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories"},priority=10)
public void eleven_ADDTOCART()
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	Assert.assertTrue(isDisplayed(driver,shoppingCartPage.getObeyPropagandaHat()));
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories","updateShoppingCart"},priority=11)
public void twelvth_VerifyUpdateShoppingCart() throws InterruptedException
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	String beforeUpdate=shoppingCartPage.textInProductSubTotal();
	shoppingCartPage.updateQuantity();
	String afterUpdate=shoppingCartPage.textInProductSubTotal();
	//System.out.println("beforeupdate"+beforeUpdate+"afterUpdate"+afterUpdate);
	Assert.assertNotEquals(beforeUpdate, afterUpdate);
	
}
@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories","updateShoppingCart"},priority=12)
public void thirteen_VerifyContinueShoppingFunctionality() throws InterruptedException
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	shoppingCartPage.clickOnContinueShopping();
	accessoriesPage.clickOnRaybanAddToCart();
	accessoriesPage.clickOnShoppingCart();
	Assert.assertTrue(isDisplayed(driver,shoppingCartPage.getRaybanAviatorSunglasses()));
	
	
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories","CHECKOUT"},priority=13)
public void fourteen_VerifyCheckOutFunctionality() throws InterruptedException
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	shoppingCartPage.clickOnTermsOfService();
	shoppingCartPage.clickOnCheckOut();
	Assert.assertEquals(getTitle(driver),"nopCommerce demo store. Login");
	
	
}

@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories","CHECKOUTASGUEST"},priority=14)
public void fifteen_VerifyCheckOutASGUEST() throws InterruptedException
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	shoppingCartPage.clickOnTermsOfService();
	shoppingCartPage.clickOnCheckOut();
	
	loginPage.clickOnCheckOutAsGuest();
	
}
@Test(groups= {"Apparel","Apparel_on_HomePage","Accessories","CHECKOUTPage"},priority=15)
public void sixteen_VerifyUserCanCheckOutOrderAsGuest() throws InterruptedException
{
	homePage.clickOnAccessoriesUnderApparelOnHeaderMenu();
	accessoriesPage.clickOnAddToCart();
	obeypropogandaHatPage.selectingSizeOption();
	obeypropogandaHatPage.clickOnAddToCart();
	obeypropogandaHatPage.clickOnShoppingCartOfNotificationBar();
	shoppingCartPage.clickOnTermsOfService();
	shoppingCartPage.clickOnCheckOut();
	
	loginPage.clickOnCheckOutAsGuest();
	checkOutPage.fillBillingAddressDetails();
	//String s=checkOutPage.getSuccessMsg();
	Assert.assertEquals(checkOutPage.getSuccessMsg(), "Your order has been successfully processed!");
	
}

}
