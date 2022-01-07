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

public class CreateaProductSteps {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^The user is at welcome page to login$")
    public void WelcomeLogin() {
    	
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }
    
    @And("^The User enters\"(.*)\"and\"(.*)\"$")
    public void Admin_user_enters_and(String Username, String Password) throws Throwable {
    	
    	driver.findElement(By.id("user_name")).sendKeys(Username);
	    driver.findElement(By.id("username_password")).sendKeys(Password);
	    driver.findElement(By.id("bigbutton")).click();
	
    }
    
    @When ("^User navigates to All option$")
    public void ClickAll() {
    	
    	//All tab

    			WebElement AllTab = driver.findElement(By.xpath("//*[@id='grouptab_5']"));

    			wait.until(ExpectedConditions.elementToBeClickable(AllTab));

    			//click on All tab

    			AllTab.click();

    	
    }
    
   @And ("^Select the Product option$")
   public void ClickProduct() throws InterruptedException {
	    Thread.sleep(1000);
		WebElement Productoption= driver.findElement(By.linkText("Products"));

		Productoption.click();
		Productoption.click();

		Thread.sleep(5000);
   }
    
   
   @And ("^Clicks on Create Product option$")
   public void ClickCreateProduct() throws InterruptedException {
	   
	   driver.findElement(By.linkText("Create Product")).click();
   	
   	   Thread.sleep(5000);
   }
   
   @And ("^User  enters product name as\"(.*)\"$")
   public void User_enters_product_name_as_(String ProductName) {
	   
	   driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(ProductName);
	   
   }
   
   @And ("^Enter other details as\"(.*)\"to Save the Product$")
   public void Enter_other_details_as_to_Save_the_Product_(String Price) throws InterruptedException {
	   
	   driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(Price);
	   driver.findElement(By.xpath("//*[@id=\"SAVE\"]")).click();
	   
	   Thread.sleep(5000);
	      
   }
   
   @Then ("^Navigates to the View Products Page$")
   public void validate () {
	   
	   driver.findElement(By.linkText("View Products")).click();
	   
   }
   
   @And ("^Exit from browser$")
   public void Exit() {
	   
	   driver.close();
   }
   }

