package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPageOR {

	WebDriver driver;
	
	public LogInPageOR(WebDriver driver)
	{
		this.driver= driver;
		
		
	}
	
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By LogInBtn = By.xpath("//input[@name='submit']");
	By logInErrorMessage = By.xpath("//div[@class='info info--error']"); 
	
	public WebElement username()
	{
		
		return(driver.findElement(username));
	}
	
	
	
	public WebElement password()
	{
		
		return(driver.findElement(password));
	}
	public WebElement LogInBtn()
	{
		
		return(driver.findElement(LogInBtn));
	}


	public WebElement logInErrorMessage()
	{
		
		return(driver.findElement(logInErrorMessage));
	}
}
