package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validationnavigationbar extends base{
	private static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("driver initialize");
		driver.get(prop.getProperty("url"));
		log.info("URL is sucesfully load");
	}
	
	@Test
	public void validatingnavigationbar() throws IOException {
		
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed on landing page");
		
		
				
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
