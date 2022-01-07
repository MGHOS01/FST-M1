package JobBoardProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
  
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
		
	@Test
	public void newJobViaBackendTestCase() throws InterruptedException {
		// Entering username
		WebElement UserID = driver.findElement(By.id("user_login"));
		UserID.sendKeys("root");
		// Entering password
		WebElement Password = driver.findElement(By.id("user_pass"));
		Password.sendKeys("pa$$w0rd");	    
		// Clicking on "Log In" button
		driver.findElement(By.id("wp-submit")).click();
		// Verifying log in is successful or not
		WebElement element = driver.findElement(By.tagName("h1"));
		String LoginPage = element.getText();
		if (LoginPage.equals("Dashboard")) {
			System.out.println("User logged in successfully");
		}
		else {
			System.out.println("User is unable to login");
		}
				
		// Clicking on "Job Listings" item on the left hand menu
		driver.findElement(By.cssSelector("#menu-posts-job_listing > a > div.wp-menu-name")).click();
		// Asking selenium to wait until the new page appears 
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a.page-title-action"))));
		// Clicking on "Add New" button 
		driver.findElement(By.cssSelector("a.page-title-action")).click();	
		// Waiting till page loads
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Closing "Welcome to the Block Editor "pop-up
		driver.findElement(By.cssSelector(".components-modal__header > button:nth-child(2) > svg:nth-child(1)")).click();
		// Waiting for pop-up to close
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".editor-post-title"))));
		
		// Entering the position
		WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"post-title-0\"]"));
		String jobTitleEntry = "SDET";
		jobTitle.sendKeys(jobTitleEntry);
		// Entering the description
		driver.findElement(By.xpath("//div[starts-with(@id,'editor-')]")).sendKeys("This poistion is for the role of SDET."
				+ "Person applying for this position is expected to adept with Java and Selenium.");
		// Entering the company website
		driver.findElement(By.id("_company_website")).sendKeys("https://www.ibm.com/in-en");
		// Entering the company twitter handle
		driver.findElement(By.id("_company_twitter")).sendKeys("@IBM");
		// Entering the job location
		driver.findElement(By.id("_job_location")).sendKeys("Pune");
		// Entering the company name
		driver.findElement(By.id("_company_name")).sendKeys("IBM India Pvt.Ltd.");
		// Entering the company tagline
		driver.findElement(By.id("_company_tagline")).sendKeys("THINK");
		// Entering the listing expiry date
		driver.findElement(By.xpath("//input[@id='_job_expires']")).sendKeys("December 31, 2025");
		// Clicking on "Publish" button
		driver.findElement(By.cssSelector("button.components-button:nth-child(3)")).click();
		// Waiting for it and clicking on the 2nd "Publish" button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".editor-post-publish-button"))));
		driver.findElement(By.cssSelector(".editor-post-publish-button")).click();
		// Waiting for it and clicking on "View Job" button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".post-publish-panel__postpublish-buttons > a:nth-child(1)"))));
		driver.findElement(By.cssSelector(".post-publish-panel__postpublish-buttons > a:nth-child(1)")).click();
		// Verifying if job is posted successfully
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".site-title > a:nth-child(1)"))));
		Assert.assertTrue(driver.getTitle().toString().contains(jobTitleEntry.toString()));
		System.out.println("\n"+ jobTitleEntry + " : The job listing was posted successfully");
	}
	  
	@AfterMethod
	public void afterMethod() {
		// Close browser
		driver.close();
	}

}