package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	@FindBy(className = "inventory_item_name")
	private WebElement iteminfo;
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getItemInfo()
	{
		return iteminfo;
	}
	
	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	//Business library
		/**
		 * This method will capture the item name and return it to caller
		 * @return
		 */
		public String getItemName()
		{
			return iteminfo.getText();
		}
		
		
		/**
		 * This method will click on remove button
		 */
		public void clickOnRemoveBtn()
		{
			removeBtn.click();
		}
}
