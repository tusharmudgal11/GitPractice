package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id = "user-name")
	private WebElement username_Edit;
	
	@FindBy(id = "password")  
	private WebElement passwordEdit;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	

	
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
     public  WebElement getusernameEdit()
     {
    	 return username_Edit;
     }
     
     public WebElement getPasswordedit()
     {
    	 return passwordEdit;
     }
     
     public WebElement getloginbutton()
     {
    	 return loginBtn;
     }
     
    
     
     // business libarary
     
     /**
      * 
      * this method will perform login operation
      */
     public void loginToApp(String Username,String password)
     {
    	 username_Edit.sendKeys(Username);
    	 passwordEdit.sendKeys(password);
    	 loginBtn.click();
     }
}
