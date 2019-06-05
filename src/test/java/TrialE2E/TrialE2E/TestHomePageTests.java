package TrialE2E.TrialE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageOR;
import PageObjects.LogInPageOR;


public class TestHomePageTests extends Base {
	
	// this will force a reconfiguration

	
	//private static final Logger log = LogManager.getLogger();
	private static Logger log =LogManager.getLogger(TestHomePageTests.class.getName());
	
	

	@BeforeTest

	public void initiate() throws IOException

	{
		
		WebDriver driver = launchBrowser();
		driver.get("https://www.ocado.com");
		log.info("Driver Initialized successfully");

	}

	@Test(dataProvider = "datasets")

	public void HomePageTest(String username, String Password) throws IOException

	{

		LogInPageOR lp = new LogInPageOR(driver);
		HomePageOR hp = new HomePageOR(driver);
		/*
		 * LogInPageOR lp = new LogInPageOR(driver); HomePageOR hp = new
		 * HomePageOR(driver);
		 */
		
		 
		
//driver.findElement(By.xpath("//div[@id='searchWrapper']")).click();
//driver.findElement(By.xpath("//div[@id='searchWrapper']")).sendKeys("Oil");
//hp.searchbox().sendKeys("Eggs");
		int i = driver.findElements(By.tagName("a")).size();
		System.out.println("The total number of links is:: " + i);

		hp.loginBtn().click();
	//	takeSnap() ;
		log.debug("Login button clicked successfully");
		lp.username().sendKeys(username);
		lp.password().sendKeys(Password);
		lp.LogInBtn().click();
		driver.get("https://www.ocado.com");
		log.error("Ocado Launched again");
		//log.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver = null;


	
	}

	@DataProvider

	public Object[][] datasets()

	{
		Object[][] data = new Object[3][2];

		data[0][0] = "Userid1@gmail.com";
		data[0][1] = "Password1";

		data[1][0] = "Userid2@gmail.com";
		data[1][1] = "Password2";

		data[2][0] = "Userid2@gmail.com";
		data[2][1] = "Password2";

		return data;

	}

}
