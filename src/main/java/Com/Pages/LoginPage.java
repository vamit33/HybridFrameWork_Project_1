package Com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[3]/div/button")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
  public void loginToApplication(String uname, String pass) {
	  
	  username.sendKeys(uname);
	  password.sendKeys(pass);
	  loginButton.click();
	
	
}
}
