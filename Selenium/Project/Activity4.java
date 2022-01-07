package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/jobs/");
	  }
	
	  @Test
  	  public void secondHeaderTestCase() {
		  // Fetching the 2nd header of the webpage
		  String heading2 = driver.findElement(By.xpath("//h2")).getText();
		  // Printing the 2nd header
		  System.out.println("Website's second heading is: " + heading2);
		  // Assertion for value verification of the header
		  Assert.assertEquals("Quia quis non", heading2);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
  

}
