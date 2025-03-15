package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import GenericUtility.FileUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InvantoryPage;
import ObjectRepository.InventoryItemPage;

public class AddProductToCartTest 
{
	FileUtility futil = new FileUtility();
	
	public void tc_001_addproductToCart() throws EncryptedDocumentException, IOException
	{
		//  Read The Data From Files
		String PRODUCTNAME = futil.readDataFromExcelFile("Product", 1, 2);
		
		WebDriver driver = new ChromeDriver();
		//Click on Product
		InvantoryPage ip = new InvantoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add product to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to cart
		ip.clickOnCartContainer();
		
		//Validate in the Cart page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		Assert.assertEquals(productInCart,productAdded);
		
		Assert.assertTrue(productInCart.equals(productAdded));
		
		
		
	}
	

}
