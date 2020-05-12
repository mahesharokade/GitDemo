package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By emailAddress=By.cssSelector("[id='user_email']");
	private By password=By.cssSelector("[type='password']");
	private By loginButton=By.cssSelector("[value='Log In']");
	private By forgotLink=By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public ForgotPasswordLink forgotlink() {
		driver.findElement(forgotLink).click();
		return new ForgotPasswordLink(driver);
	}
	public WebElement emailAddress() {
		return driver.findElement(emailAddress);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}
}
