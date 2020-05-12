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

public class validation extends base{
	private static Logger log=LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	LandingPage l;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("driver initialize");
		driver.get(prop.getProperty("url"));
		log.info("URL is sucesfully load");
	}
	
	@Test
	public void validatingAppTest() throws IOException {
		
		l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		log.info("text matches on landing page");
		
		
				
	}
	@Test
	public void validatingHeader() throws IOException {
		
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("text matches on landing page");
		
		
				
	}
	//done by gitX
	@Test
	public void validatingHeader2() throws IOException {
		
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("text matches on landing page");
		
		
				
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		//driver=null;
	}
	
	
	

}
