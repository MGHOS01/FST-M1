package SeleniumTraining;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity7_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        WebElement chosen = driver.findElement(By.id("single-value"));
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        dropdown.selectByVisibleText("Option 2");
        System.out.println(chosen.getText());
        dropdown.selectByIndex(3);
        System.out.println(chosen.getText());
        dropdown.selectByValue("4");
        System.out.println(chosen.getText());
        List<WebElement> options = dropdown.getOptions();
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }
        
        driver.close();
    }
}