package InventoryPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.FileUtility;
import GenericUtility.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InvantoryPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.LoginPage;

public class AddProductTOCartTest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Create Object for reference
		SeleniumUtility sUtil = new SeleniumUtility();
		FileUtility fUtil = new FileUtility();
		
		//Read Data from Files
		
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("user_name");
		String PASSWORD = fUtil.readDataFromPropertyFile("Password");
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Sheet1", 1, 2);

		//Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Load the app
		driver.get(URL);
		
		//Login to App
	
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
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
		
		if(productInCart.equals(productAdded))
		{
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout
		ip.logoutOfApp();
		
		
		
	}

}
