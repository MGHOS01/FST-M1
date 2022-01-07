package SeleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	     driver.get("https://www.training-support.net/selenium/tables");
	     List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
	     System.out.println("Number of columns: " + cols.size());
	     List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
	     System.out.println("Number of columns: " + rows.size());
	        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
	    	
	        for(WebElement cellValue : thirdRow) {
		
	            System.out.println("Cell Value: " + cellValue.getText());
		
	        }
	     WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
	     System.out.println("Second row, second column value: " + cellValue2_2.getText());
	     driver.close();
	}

}
