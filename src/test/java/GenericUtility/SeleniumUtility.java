package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility 
{
	/**
	 * This method make the window maximize
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method make window minimize
	 * @param driver
	 */
	
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This is for make window wait
	 */
	
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method wait for 10 second for element to be visible
	 * @param driver
	 * @param element
	 */
	
	
	public void waitforElement(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	
		
	}
	
	/**
	 * This Method Wait for 10 sec to click the element
	 * @param driver
	 * @param element
	 */
	
	
	public void waitforElementtobeClickable(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This Method Help to Handle DropDown
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,  int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
		
			
	}
	
	/**
	 * This Method Handle method by Value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element,  String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
		
			
	}
	/**
	 * This Method Handle Value By Visibletext
	 * @param visibletext
	 * @param element
	 */
	
	public void handleDropDown(String visibletext , WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
   }
	
	/**
	 * This method is used to perform mouse hovering action on  webelement
	 * @param driver
	 * @param element
	 */
	
	public void mouseoveraction(WebDriver driver , WebElement element)
	{
		Actions act =  new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method used for double click
	 * @param driver
	 * @param element
	 */
	
	public void doubleclick(WebDriver driver , WebElement element)
	{
		Actions act =  new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * this method is used to perform right click 
	 * @param driver
	 * @param element
	 */
	
	public void rightclick(WebDriver driver , WebElement element)
	{
		Actions act =  new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This is used to drag and drop the element
	 * @param driver
	 * @param srcelement
	 * @param targelement
	 */
	
	
	public void dragdrop(WebDriver driver , WebElement srcelement,WebElement targelement)
	{
		Actions act =  new Actions(driver);
		act.dragAndDrop(srcelement, targelement).perform();
	}
	
	/**
	 * this will scroll to particular webelement
	 * @param driver
	 * @param element
	 */
	
	public void scrolltoElementAction(WebDriver driver , WebElement element)
	{
		Actions act =  new Actions(driver);
		act.scrollToElement(element).perform();
	}
	

      //Frame Handling ,WindowHandling, Alert
	
	/**
	 * this method handle frame by index
	 * @param driver
	 * @param index
	 */
	public void handleframesIndes(WebDriver driver , int index)
    {
    	driver.switchTo().frame(index);
    }
	/**
	 * this method handle frame by name or id 
	 * @param driver
	 * @param nameorid
	 */

    public void handleframes(WebDriver driver , String nameorid)
    {
    	driver.switchTo().frame(nameorid);
    }
    /**
     * this method handle frame by elelemnts 
     * @param driver
     * @param element
     */
    
    public void handleframe(WebDriver driver , WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
    /**
     * This method Switch the control to parent frame
     * @param driver
     */
    
    public void switchtoParentFrame(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    /**
     * This method  will switch to window
     * @param driver
     * @param windowid
     */
    
    
    public void switchToWindow(WebDriver driver,String windowid)
    {
    	driver.switchTo().window(windowid);
    }
    
    /**
     * this method accept alert
     * @param driver
     */
    
    public void aceeptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    /**
     * this metrhod dismiss popup
     * @param driver
     */
    
    public void dismissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    /**
     * This method will get alert text
     */
    
    public String getAlertText(WebDriver driver)
    {
    	return  driver.switchTo().alert().getText();
    }
    
    /**
     * this method enter data to alert popup
     */
    
    public void enterDatetoAlert(WebDriver driver,String data)
    {
    	driver.switchTo().alert().sendKeys(data);
    }
    /**
     * This method is used to capture the screenshot
     * @param sdriver
     * @param screenshotname
     * @return
     * @throws IOException
     */
    /**
	 * This method will capture the screenshot and return the path to caller
	 * @param sdriver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
    /**
	 * This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\"
				+ "ScreenShot\\"+screenshotName+"+.png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For Extent reports
		
		//addProductTocart - ts - addProductCart-22-02-2025-14-21-32.png;
		//addProductTocart - ts - addProductCart-22-02-2025-14-45-32.png;
		

	} 
    	
    	
    }
    	
    
    
    
