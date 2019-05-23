package TrialE2E.TrialE2E;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Base {
	
	WebDriver driver = null;
	public Properties pro = new Properties();

	public Base(WebDriver driver) {
		this.driver = driver;
		
	} 
	@Test
	public WebDriver launchBrowser() throws IOException
	
	{  
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Gulmi-Workspace2\\OcadoE2E\\prop.properties");
		
		pro.load(fis);
		
	
		
		//String browserName = "chrome";
		
		String browserName =pro.getProperty("browserName");
		System.out.println(browserName);
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\2018-JobSearch\\Learning Selenium with Java\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\2018-JobSearch\\Learning Selenium with Java\\BrowserDrivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

		
	}


