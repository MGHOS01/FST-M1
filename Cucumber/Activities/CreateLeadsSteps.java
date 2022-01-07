package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadsSteps {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^The user is at login page$")
    public void LoginPage() {
    	
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }
    
    @And("^Admin User enters\"(.*)\"and\"(.*)\"$")
    public void Admin_user_enters_and(String Username, String Password) throws Throwable {
    	
    	driver.findElement(By.id("user_name")).sendKeys(Username);
	    driver.findElement(By.id("username_password")).sendKeys(Password);
	    driver.findElement(By.id("bigbutton")).click();
	
    }
    
    @When ("^User navigates to Sales Page$")
    public void ClickSales() {
    	
    	//sales tab

    			WebElement SalesTab = driver.findElement(By.xpath("//*[@id='grouptab_0']"));

    			wait.until(ExpectedConditions.elementToBeClickable(SalesTab));

    			//click on sales tab

    			SalesTab.click();

    	
    }
    
    @And ("^Select the Leads option")
    public void ClickLeads() throws InterruptedException {
    	
    	WebElement Leadsoption= driver.findElement(By.xpath("//*[@id='moduleTab_9_Leads']"));

		Leadsoption.click();

		Thread.sleep(5000);
    }
    
    @And ("^Clicks on Create Lead option$")
    public void ClickCreateLead() throws InterruptedException {
    	
    	driver.findElement(By.linkText("Create Lead")).click();
    	
    	Thread.sleep(5000);
    }
    
    @And("^User enters the values\"(.*)\"and\"(.*)\"and\"(.*)\"$")
    public void User_enters_the_values_and_(String FirstName, String LastName, String EmailID) throws Throwable {
    	
    	WebElement Name = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
    	wait.until(ExpectedConditions.elementToBeClickable(Name));
    	Name.sendKeys(FirstName);
    	
    	WebElement Surname = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
    	wait.until(ExpectedConditions.elementToBeClickable(Surname));
    	Surname.sendKeys(LastName);
    	
    	WebElement Email = driver.findElement(By.xpath("//*[@id=\"Leads0emailAddress0\"]"));
    	wait.until(ExpectedConditions.elementToBeClickable(Email));
    	Email.sendKeys(EmailID);
    	
    }
    
    @And ("^Saves the Lead$")
    public void SaveLead() {
    	driver.findElement(By.id("SAVE")).click();
    }
    
    @Then ("^Navigates to the View Leads Page to see results$")
    public void NavigatePage() {
    	
    	driver.findElement(By.cssSelector("li.actionmenulinks:nth-child(4) > a:nth-child(1) > div:nth-child(2)")).click();
    }
    
    @And ("^Closes the browser$")
    public void CloseBrowser() {
    	
    	driver.close();

    }
}
