package TrialE2E.TrialE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import PageObjects.HomePageOR;
import PageObjects.LogInPageOR;
import junit.framework.Assert;


public class TestValidateLogInMessage extends Base{
	
	private static Logger log =LogManager.getLogger(TestHomePageTests.class.getName());
	
	
	
	//HomePageTests hpt = new HomePageTests();
	@Test
	public void TextValidation() throws IOException
	{
		
		driver = launchBrowser();
		driver.get(pro.getProperty("url"));
		HomePageOR hp = new HomePageOR(driver);
		hp.loginBtn().click();
		LogInPageOR lp = new LogInPageOR(driver);
		lp.username().sendKeys("tryyte@teet.com");
		lp.password().sendKeys("huihui");
		//Assert.assertTrue(lp.LogInBtn().isDisplayed());
		lp.LogInBtn().click();
		log.debug("Log In Clixk"
				+ "ed");
		System.out.println("The error is::::"+lp.logInErrorMessage().getText());
		Assert.assertEquals("123We're having trouble confirming your login details. Maybe you typed them incorrectly? Please try again.", lp.logInErrorMessage().getText());
		System.out.println("This test should fail");
		
	}
	

	
	
}
	
	
