package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordLink {
	
	public WebDriver driver;
	
	By emailAddress=By.cssSelector("[id='user_email']");
	By sendMeInstructions=By.cssSelector("[type='submit']");
	
	
	public ForgotPasswordLink(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement emailAddress() {
		return driver.findElement(emailAddress);
	}
	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}
	
}
