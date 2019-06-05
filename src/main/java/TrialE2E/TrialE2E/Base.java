package TrialE2E.TrialE2E;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;





public class Base {
	
	//private static final DriverManagerType CHROME = null;
	public static WebDriver driver;
	public Properties pro = new Properties();


	@Test
	public WebDriver launchBrowser() throws IOException
	
	{  
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\User\\Gulmi-Workspace2\\OcadoE2E\\prop.properties");
	
		FileInputStream fis = new FileInputStream("prop.properties");
		
		pro.load(fis);
		
	
		
		//String browserName = "chrome";
		
		String browserName =pro.getProperty("browserName");
		System.out.println(browserName);
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\2018-JobSearch\\Learning Selenium with Java\\BrowserDrivers\\chromedriver.exe");
			
			//WebDriverManager.getInstance(CHROME).setup();
			
		WebDriverManager.chromedriver().setup();
			
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

		
	public void takeSnap(String snapName) throws IOException
	{
		System.out.println("Taking screenshot");
		
		TakesScreenshot snap = (TakesScreenshot)driver;
		File currScreen = snap.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(currScreen, new File("C:\\Users\\User\\Gulmi-Workspace2\\OcadoE2E\\test-output\\testScreenshots//"+ snapName +".png"));
		
		System.out.println(" screenshot taken");
		
	}
	
	
	
	
	
	
	}


