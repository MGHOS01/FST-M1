package JobBoardProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Activity5 {

WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
	    //Create a new instance of the Firefox driver
	    driver = new FirefoxDriver();
	    //Open browser
		driver.get("https://alchemy.hguy.co/jobs");
	}
	
	@Test
	public void pageTitleAfterJobsClickTestCase() {
		// Clicking on the "Jobs" menu button
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();	
		// Saving the actual title of new webpage after click on "Jobs" menu button
		String actualTitle = driver.getTitle();
		// Printing the new webpage title
		System.out.println("Title of the page after clicking on 'Jobs' menu item is: " + actualTitle);		
		// Saving the expected title page into a string variable
		String expectedTitle = "Jobs – Alchemy Jobs";
		// Assertion to see if the "Jobs" menu button has landed us into the correct page
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void afterMethod() {
	    //Close the browser
	    driver.quit();
	}

}
