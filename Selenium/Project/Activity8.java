package JobBoardProject;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Activity8 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void beforeTest() {
		// Instantiate the driver
		driver = new FirefoxDriver();
		// Open the URL
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	// Creating Data Provider for Username and Password fields
	@DataProvider(name = "Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{"root","pa$$w0rd"}};
	}
	
	@Test(priority=0)
	public void loginPageTestCase() {
		// Assert if log in page is open
		Assert.assertEquals(driver.getTitle(), "Log In ‹ Alchemy Jobs — WordPress");
	}
	
	@Test(priority=1,dataProvider = "Authentication")
	public void backendLoginTestCase(String username, String password) throws InterruptedException {
		// Enter username
		driver.findElement(By.xpath("//p//input[@name = 'log']")).sendKeys(username);
		// Enter password
		driver.findElement(By.xpath("//div//input[@name = 'pwd']")).sendKeys(password);
		// Click on LogIn button
		driver.findElement(By.cssSelector("#wp-submit")).click();
		// Instantiate the wait
		wait = new WebDriverWait(driver,10);
		// Wait for new page to load
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#wp-submit")));
		// Assert if backend log-in is successful by verifying new page title
		Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress");
	}
  
	@AfterTest
	public void afterTest() {
		// Close the browser
		driver.close();
	}

}
