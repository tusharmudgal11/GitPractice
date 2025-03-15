package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;

public class AddProductToCart extends BaseClass {

	//public static void main(String[] args) throws EncryptedDocumentException, IOException, Throwable
	
	@Test
	public void tc001_AddProductToCart() throws IOException
	{
		
      //  FileUtility file = new FileUtility();
	 //  SeleniumUtility sel = new SeleniumUtility();
	 //  JavaUtility jutil = new JavaUtility();
	   
	   //Read Properties Data
	   // properties file - CommonData
	 //  String url = file.readDataFromPropertyFile("url");
	 //  String User_Name = file.readDataFromPropertyFile("user_name");
	  // String Password = file.readDataFromPropertyFile("Passsword");
		
	///	WebDriver driver = new ChromeDriver();
		//driver.get(url);
		//sel.maximizeWindow(driver);
		//sel.addImplicitlyWait(driver);
		
		//driver.findElement(By.id("user-name")).sendKeys(User_Name);	
		//driver.findElement(By.name("password")).sendKeys(Password);
	//	driver.findElement(By.name("login-button")).click();
		String SORTOPTION = file.readDataFromExcelFile("Sheet1", 7, 2);
		  String PRODUCTNAME = file.readDataFromExcelFile("Sheet1", 7, 3);
		  System.out.println(PRODUCTNAME); 
		    
		  WebElement SortProduct = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		     sel.handleDropDown(SORTOPTION,SortProduct);
		    
		     
		    
		 
		 
			
			
		 

	}

}
