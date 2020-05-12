package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public String getscreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}

}
