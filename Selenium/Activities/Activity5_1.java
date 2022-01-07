package SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		String pageTitle = driver.getTitle();	
        System.out.println("The page title is" +pageTitle);
        WebElement checkboxisVisible = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxisVisible.isDisplayed());
        driver.findElement(By.xpath("//button[@id= 'toggleCheckbox']")).click();            	
        System.out.println("The checkbox Input is displayed: " + checkboxisVisible.isDisplayed());
        driver.close();
	}

}

