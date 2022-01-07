package JobBoardProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	  
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
		
	}
	@Test
	public void applyForJobTestCase() throws InterruptedException {
	    // Instantiating webdriver wait
		wait = new WebDriverWait(driver, 10);
	    // Fetching the "Jobs" menu button into a web element
		WebElement JobsMenuItem = driver.findElement(By.linkText("Jobs"));
	    // Clicking the "Jobs" menu button
		JobsMenuItem.click();
	    // Fetching the header object of new loaded page into a web element
		WebElement JobsPageTitle = driver.findElement(By.tagName("h1"));
	    // Asking selenium to wait until the new page is loaded along with it's header element
		wait.until(ExpectedConditions.visibilityOf(JobsPageTitle));
	    // Fetching the search text entry field into a web element
		WebElement Search =driver.findElement(By.id("search_keywords"));
	    // Searching the jobs listing by sending keys input with keywords
		Search.sendKeys("automation");
	    // Clicking the "Search Jobs" button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    // Waiting for search results to load
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'showing_jobs')]"))));
		// Passing the search results into a web elements list
		List <WebElement> jobsList = driver.findElements(By.xpath("//ul[@class='job_listings']//li"));
		// Finding which job listed is available and then clicking it
		
		for (int i=0; i<jobsList.size(); i++) {
		    WebElement job = jobsList.get(i);
		    if (job.getAttribute("class").toString().contains("job") && !job.getAttribute("class").toString().contains("filled")) {
		    	job.click();
		    	break;
		        }         
		    }
		// Waiting for job page to load 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class = 'application_button button']"))));
		// Clicking on "Apply for job" button
		driver.findElement(By.xpath("//input[@class = 'application_button button']")).click();
	    
		String emailId = driver.findElement(By.xpath("//a[@class = 'job_application_email']")).getText();
	    System.out.println("To apply for this job email your details to : " + emailId);
	  }
	  
	@AfterMethod
	public void afterMethod() {
		driver.close();
	  }

}
