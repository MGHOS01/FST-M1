package JobBoardProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	WebDriver driver;

	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
	      driver.get("https://alchemy.hguy.co/jobs");
	  }
	
	  @Test
	  public void ImageURL() {
		  // Fetching the header image as web element
		  WebElement Image = driver.findElement(By.className("attachment-large"));
		  // String the image source into a string variable
		  String srcURL = Image.getAttribute("src");
		  // Printing the image source
		  System.out.println("URL of the header image is: \n" +srcURL);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
