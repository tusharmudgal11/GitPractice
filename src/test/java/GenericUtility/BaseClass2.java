package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.InvantoryPage;
import ObjectRepository.LoginPage;

public class BaseClass2 
{
	
	public FileUtility fUtil1 = new FileUtility();
	public SeleniumUtility sUtil1 = new SeleniumUtility();
	public JavaUtility jUtil1 = new JavaUtility();
	public WebDriver driver1;
	
	//for listeners
	public static WebDriver sdriver1;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig1()
	{
		System.out.println("---- Database Connection Successful ----");
		
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig1(/*String BValue*/) throws IOException
	{
		String URL = fUtil1.readDataFromPropertyFile("url");
		
		driver1 = new EdgeDriver();
		
		/*For cross Browser Execution*/
//		if(BValue.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BValue.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		/*--------------------------------------*/
		
		
		sUtil1.maximizeWindow(driver1);
		sUtil1.addImplicitlyWait(driver1);
		
		driver1.get(URL);
		
		System.out.println("---- Browser Launch Successful ----");
		
		//For Listeners
		sdriver1 = driver1;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig1() throws IOException
	{
		String USERNAME = fUtil1.readDataFromPropertyFile("username");
		String PASSWORD = fUtil1.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver1);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("---- Login to App Successful ----");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig1()
	{
		InvantoryPage ip = new InvantoryPage(driver1);
		ip.logoutOfApp();
		
		System.out.println("---- Logout of App Successful ----");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig1()
	{
		driver1.quit();
		
		System.out.println("---- Browser closure Successful ----");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig1()
	{
		System.out.println("---- Database closure Successful ----");
	}
		
}
