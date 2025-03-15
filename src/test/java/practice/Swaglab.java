package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;

public class Swaglab {

	public static void main(String[] args) throws IOException 
	{
		
        FileUtility file = new FileUtility();
	   SeleniumUtility sel = new SeleniumUtility();
	   JavaUtility jutil = new JavaUtility();
	   
	   //Read Properties Data
	   // properties file - CommonData
	   String url = file.readDataFromPropertyFile("url");
	   String User_Name = file.readDataFromPropertyFile("user_name");
	   String Password = file.readDataFromPropertyFile("Passsword");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		sel.maximizeWindow(driver);
		sel.addImplicitlyWait(driver);
		driver.findElement(By.id("user-name")).sendKeys(User_Name);	
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("login-button")).click();
	}

}
