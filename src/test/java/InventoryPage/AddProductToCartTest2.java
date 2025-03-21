package InventoryPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.BaseClass2;
import ObjectRepository.CartPage;
import ObjectRepository.InvantoryPage;
import ObjectRepository.InventoryItemPage;


@Listeners(GenericUtility.ListenersImplementation.class)

public class AddProductToCartTest2 extends BaseClass
{

	@Test(groups = "SmokeSuit") 
	public void tc_001_addproductToCart() throws IOException
	{
		
		//Read the Data from Files
	      
		
		String PRODUCTNAME =  file.readDataFromExcelFile("Sheet1", 1, 2);
		System.out.println(PRODUCTNAME);  
		
		//Click on Product
		InvantoryPage ip = new InvantoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);
		
	
		
		//Add product To cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to cart 
		ip.clickOnCartContainer();
		
		//Validate in the Cart page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();                                            
		Assert.assertEquals(productInCart, productAdded);
		
		Assert.assertTrue(productInCart.equals(productAdded));
		System.out.println(productInCart);
		
		
	}
}

