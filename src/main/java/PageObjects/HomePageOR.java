package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageOR {
	WebDriver driver;
	public HomePageOR(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	

// Objects:
	By searchbox = By.xpath("//div[@id='searchWrapper']");
	
	By logInBtn = By.id("loginButton");
	
//Functions returning Objects:
	
	public WebElement searchbox()
	{
		return (driver.findElement(searchbox));
		
		
	}
	
public WebElement loginBtn()
{
	
	
	return (driver.findElement(logInBtn));
	


}

}