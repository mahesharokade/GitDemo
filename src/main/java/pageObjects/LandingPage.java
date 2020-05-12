package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By getTitle=By.xpath("//h2[text()='Featured Courses']");
	private By navBar=By.cssSelector("[class='nav navbar-nav navbar-right']");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	public WebElement getTitle() {
		return driver.findElement(getTitle);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
