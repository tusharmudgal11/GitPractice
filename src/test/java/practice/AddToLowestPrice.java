package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;
import ObjectRepository.LoginPage;

public class AddToLowestPrice extends BaseClass {

	//public static void main(String[] args) throws IOException, InterruptedException 
	@Test
	public void tc_002AddLowestPrice() throws IOException
	{
	  // FileUtility file = new FileUtility();
	  // SeleniumUtility sel = new SeleniumUtility();
	  // JavaUtility jutil = new JavaUtility();
	   
	   //Read Properties Data
	   // properties file - CommonData
	  // String Url = file.readDataFromPropertyFile("url");
	  // String User_Name = file.readDataFromPropertyFile("user_name");
	  // String Password = file.readDataFromPropertyFile("Passsword");
	   
	   // Read Test Data from Excel file
	   String SORTOPTION = file.readDataFromExcelFile("Sheet1", 7, 2);
	   String PRODUCTNAME = file.readDataFromExcelFile("Sheet1", 7, 3);
	   System.out.println(PRODUCTNAME);
	   
	   //LAUNCH WEBBROWSER
	   WebDriver driver = new ChromeDriver();
	   sel.maximizeWindow(driver);
	   sel.addImplicitlyWait(driver);
	   
	   //load the Application
	  // driver.get(Url);
	   
	   // login to application
	  // driver.findElement(By.id("user-name")).sendKeys(User_Name);
	  // driver.findElement(By.id("password")).sendKeys(Password);
	  // driver.findElement(By.name("login-button")).click();
	   
	   LoginPage pg = new LoginPage(driver);
	 //  pg.getusernameEdit().sendKeys(User_Name);
	    // pg.getPasswordedit().sendKeys(Password);
	  // pg.loginToApp(User_Name, Password);
	  // pg.getloginbutton().click();
	  
	   
	   WebElement SortProduct = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	     sel.handleDropDown(SORTOPTION,SortProduct);
	     sel.addImplicitlyWait(driver);
	     
	     
	  // Click on the lowest product
	     WebElement Product = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
			String productToBeAdded = Product.getText();
			Product.click();
			
		// Add the product To Cart
	    driver.findElement(By.id("add-to-cart")).click();
		
	  // Navigate to Cart
	 driver.findElement(By.id("shopping_cart_container")).click();
			
			
	  
	  //// Validate
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productToBeAdded.equals(productInCart)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		} else {
			System.out.println("FAILS");
		}
		
		// Logout of Application
	//	driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		//driver.findElement(By.linkText("Logout")).click();
	   
	   

	}

}
