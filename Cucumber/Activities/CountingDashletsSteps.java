package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountingDashletsSteps {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^The user is on login page$")
    public void Page() {
     
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }
    
    @And("^Admin user enters\"(.*)\"and\"(.*)\"$")
    public void Admin_user_enters_and(String Username, String Password) throws Throwable {
    	
    	driver.findElement(By.id("user_name")).sendKeys(Username);
	    driver.findElement(By.id("username_password")).sendKeys(Password);
	    driver.findElement(By.id("bigbutton")).click();
	
    }
    
    @When("^user counts the dashlets on homepage and prints the number and name$")
    public void DashletCount() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	
    	List <WebElement> Dashlets = driver.findElements(By.xpath("//div[contains(@id,'dashlet_header_')]"));   		
    	  	
    	int Count = Dashlets.size();    	
    	System.out.println("the number of dashlets of the homepage are" + Count);
    	
    	for (WebElement webElement : Dashlets) {
            String name = webElement.getText();
            System.out.println(name);
        }
    	
    }
    
    @Then ("^The user Close the browser$")
    public void close() {
    	
    	driver.close();
    }
	
    
    	

}


