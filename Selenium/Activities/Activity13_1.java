package SeleniumTraining;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Open browser
        driver.get("https://www.training-support.net");

        //Fetching the Domain Name of the site. 
        String DomainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site: " + DomainName);

        //Fetching the URL of the site. 
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site: " + url);

        //Method document.title fetch the Title name of the site. 
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page: " + TitleName);

        //Close browser
        driver.close();
    }
}
