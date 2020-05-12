package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordLink;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Homepage extends base{
	private static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("driver initialize");
		
	}
	@Test(dataProvider="getData")
	public void landingpagevalidation(String emailAddress,String passowrd) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("URL is sucesfully load");
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();
		//LoginPage lp=new LoginPage(driver);
		lp.emailAddress().sendKeys(emailAddress);
		lp.password().sendKeys(passowrd);
		log.info("succesfully logged");
		lp.loginButton().click();
		log.info("succesfully clicked");
		ForgotPasswordLink fp=lp.forgotlink();
		fp.emailAddress().sendKeys("xxxx");
		fp.sendMeInstructions().click();
		log.info("succesfully clciked");
		
				
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="nonrestricteduser@qa.com";
		data[0][1]="123456789";
		data[1][0]="restricteduser@qa.com";
		data[1][1]="123456789";
		
		
		return data;
		
	}
	
	

}
