package TrialE2E.TrialE2E;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTests extends Base {




@Test(dataProvider = "datasets")

public void HomePageTest(String username, String Password) throws IOException

{
	driver = launchBrowser();
	driver.get("https://www.ocado.com");	


LogInPageOR lp = new LogInPageOR(driver);
HomePageOR hp = new HomePageOR(driver);
//driver.findElement(By.xpath("//div[@id='searchWrapper']")).click();
//driver.findElement(By.xpath("//div[@id='searchWrapper']")).sendKeys("Oil");
//hp.searchbox().sendKeys("Eggs");
int i = driver.findElements(By.tagName("a")).size();
System.out.println("The total number of links is: " +i);

hp.loginBtn().click();
lp.username().sendKeys(username);
lp.password().sendKeys(Password);
lp.LogInBtn().click();
	
}



@Test
public void optionalTest()
{

	System.out.println("This test is optional");
	
}


@AfterTest
public void tearDown()
{

	driver.close();

}
@DataProvider

public Object[][] datasets()

{
	Object[][] data = new Object[3][2];
	
	data[0][0] = "Userid1@gmail.com";
	data[0][1] = "Password1";

	data[1][0] = "Userid2@gmail.com";
	data[1][1] = "Password2";
	

	data[2][0] = "Userid1@gmail.com";
	data[2][1] = "Password1";
	


return data;

}

	
}
