package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.InvantoryPage;
import ObjectRepository.LoginPage;

public class BaseClass 
{
	public static WebDriver sdriver;
	/**
	 * These Method for Login ,Launch and Logout Browser
	 */
	
	public FileUtility file = new FileUtility();
	public  SeleniumUtility sel = new SeleniumUtility();
	public  JavaUtility jutil = new JavaUtility();
	public WebDriver driver;
	
	 
	 
	 @BeforeSuite  (alwaysRun = true)
	 public void bsConfig()
	 {
		 System.out.println("DataBase Connected Sucessfully");
	 }
	 
	 @BeforeClass (alwaysRun = true)
	 public void bcConfig() throws IOException
	 {
		String  URL  =  file.readDataFromPropertyFile("url");
		driver = new ChromeDriver();
		driver.get(URL);
		sel.maximizeWindow(driver);
		sel.addImplicitlyWait(driver);
		System.out.println("Browser Launch Sucessfully");
		sdriver = driver;
	 }

	 
	 @BeforeMethod(alwaysRun = true)
	 public void bmConfig() throws IOException
	 {
	 String USERNAME = file.readDataFromPropertyFile("user_name");
	 String PASSWORD = file.readDataFromPropertyFile("Password");
	 
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	System.out.println("Login Sucessfully");
	//lp.getusernameEdit().sendKeys(USERNAME);
	//lp.getPasswordedit().sendKeys(PASSWORD);
	//lp.getloginbutton();
	 
	 
	 }
	 @AfterMethod(alwaysRun = true)
	 public void amConfig()
	 {
		 InvantoryPage ip = new InvantoryPage(driver);
		 ip.logoutOfApp();
		 System.out.println("Logout Sucessfully");
	 }
	 @AfterClass(alwaysRun = true)
	 public  void asConfig()
	 {
		driver.quit();
		System.out.println("Browser close Sucessfully");
}
	 
	 @AfterSuite(alwaysRun = true)
	 public void acConfig()
	 {
	 System.out.println("DataBase close Sucessfully");
}
}

