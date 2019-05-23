package TrialE2E.TrialE2E;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateLogInMessage extends Base{
	

	
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
		System.out.println("The error is::::"+lp.logInErrorMessage().getText());
		Assert.assertEquals("We're having trouble confirming your login details. Maybe you typed them incorrectly? Please try again.", lp.logInErrorMessage().getText());
		
		
	}
	

	
	
}
	
	
