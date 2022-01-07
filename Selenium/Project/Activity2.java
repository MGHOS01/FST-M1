package JobBoardProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity2 {

	    WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        driver = new FirefoxDriver();
	        
	        driver.get("https://alchemy.hguy.co/jobs/");
	    }

	    @Test
	    public void headerTestCase() {
	    	
	    	// Fetching the 1st header of the webpage
	    	String heading= driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
	            
	        System.out.println("Website heading is: " + heading.trim());
	        
	        // Assertion for 1st header with catch block to catch exceptions
	        try {
	        Assert.assertEquals("Welcome to Alchemy Jobs", heading.trim());
	        driver.close();
	        }
	        
	        catch(Exception ex){
	        	
	        	ex.printStackTrace();
	        }
	                  
	    }

}
