package SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity13_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        WebElement secondCard = driver.findElement(By.xpath("//div[@class='spaced'][2]//div[@class='image']/img"));
        System.out.println("Image src: " + secondCard.getAttribute("src"));
        js.executeScript("window.scrollBy(0,1000)");        
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(secondCard, "src", "loading")));        
        System.out.println("Image src: " + secondCard.getAttribute("src"));
        driver.close();

    }
}
