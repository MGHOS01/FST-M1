package JobBoardProject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity7 {
	
	WebDriver driver;
	WebDriverWait wait;
	
		@BeforeMethod
		public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        // Fetching and verifying page title
        String title= driver.getTitle();
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application"); 
        }
        
		@Test
	    public void newJobTestCase() throws InterruptedException {
	    // Clicking on "Post a Job" menu button
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
	    // Instantiating webdriver wait
        wait = new WebDriverWait(driver,10);
        // Verifying if user is not logged in, then perform log in
        if (driver.findElement(By.xpath("//a[@class='button']")).getText().toString() == "Sign in") {
        	driver.findElement(By.xpath("//a[@class='button']")).click();
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='log']"))));
        	driver.findElement(By.xpath("//input[@name='log']")).sendKeys("root");
        	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("pa$$w0rd");
        	driver.findElement(By.cssSelector("#wp-submit")).click();
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("job_title"))));
        }
        // If user is already logged in, no action needed
        else {
        	;
        }
	    
        // Filling in all the input text fields needed to post a job
        
        // Entering email
        WebElement  yourEmail= driver.findElement(By.xpath("//input[@id = 'create_account_email']"));
	    Random rand = new Random();
	    // Generating random mail so that the script doesn't fail on retests
	    String email = "username"+rand.nextInt()+"@example.com";
        yourEmail.sendKeys(email);
	    // Entering job title
	    WebElement jobTitle = driver.findElement(By.xpath("//input[@id = 'job_title']")); 
	    String jobTitleEntry = "System Engineer";
	    jobTitle.sendKeys(jobTitleEntry);
	    // Entering job location
        WebElement  jobLocation= driver.findElement(By.xpath("//input[@id='job_location']"));
        jobLocation.sendKeys("Bangalore");
        // Entering job type
        WebElement  jobType= driver.findElement(By.xpath("//select[@id='job_type']"));
        // Click to see drop-down values for Job Type
        jobType.click();
        Select jobDrop = new Select(jobType);
        jobDrop.selectByVisibleText("Freelance");
        // Switching to iframe for entering Description of job
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")));
        // Entering description and switching back to main page
        WebElement  descriptionPage= driver.findElement(By.xpath("//body[@id='tinymce']"));
        descriptionPage.sendKeys("I want to apply for this Job");
        driver.switchTo().defaultContent();
        // Entering application email
        WebElement  applicationEmail= driver.findElement(By.xpath("//input[@id = 'application']"));
        applicationEmail.sendKeys("apply@example.com");
        // Entering company name
        WebElement  companyName= driver.findElement(By.xpath("//input[@id = 'company_name']"));
        companyName.sendKeys("Example India Pvt Ltd");
        // Entering company website
        WebElement  webSite= driver.findElement(By.xpath("//input[@id = 'company_website']"));
        webSite.sendKeys("https://www.example-jobs.com");
        // Clicking on "Preview" button
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        // Clicking on "Submit Listing" button
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
        // Verifying the listed job by clicking on "click here" link
        driver.findElement(By.linkText("click here")).click();
        // Assertion for verifying if job is listed
        // System.out.println(driver.getTitle().toString());
        // System.out.println(jobTitleEntry.toString());
        Assert.assertTrue(driver.getTitle().toString().contains(jobTitleEntry.toString()));
        System.out.println("\n"+ jobTitleEntry + ": Job has been posted successfully"); 
	    }
    
        @AfterMethod
        public void afterMethod() {
            //Close the browser
            driver.quit();
        }

}
