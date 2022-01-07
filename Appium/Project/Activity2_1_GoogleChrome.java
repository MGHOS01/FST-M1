package Appium_Live_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_1_GoogleChrome {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	@BeforeClass
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a054105c");
        caps.setCapability("deviceName", "Trisha's");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
  @Test
  public void ToDoList() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //opening the URL
      driver.get("https://www.training-support.net/selenium");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Scrolling
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollDescriptionIntoView(\"To-Do List Elements get added at run time\")")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Changing focus to task input
      String TaskinputLocator = "resourceId(\"taskInput\")";
      driver.findElement(MobileBy.AndroidUIAutomator(TaskinputLocator)).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Adding the tasks
      TaskinputLocator = "resourceId(\"taskInput\")";
      MobileElement addTask1 = driver.findElement(MobileBy.AndroidUIAutomator(TaskinputLocator));
      addTask1.sendKeys("Add tasks to list");
      MobileElement AddButton =driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Add Task')]"));
      AddButton.click();
      MobileElement addTask2 = driver.findElement(MobileBy.AndroidUIAutomator(TaskinputLocator));
      addTask2.sendKeys("Get number of tasks");
      AddButton.click();
      MobileElement addTask3 = driver.findElement(MobileBy.AndroidUIAutomator(TaskinputLocator));
      addTask3.sendKeys("Clear the list");
      AddButton.click(); 
      //Clicking on each task
      MobileElement Task1 = driver.findElement(By.xpath("//android.view.View[contains(@text, 'Add tasks to list')]"));
      Task1.click();  
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      MobileElement Task2 =driver.findElement(By.xpath("//android.view.View[contains(@text, 'Get number of tasks')]"));
      Task2.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      MobileElement Task3 =driver.findElement(By.xpath("//android.view.View[contains(@text, 'Clear the list')]"));
      Task3.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Clearing all the tasks
      driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Clear List')]")).click();
      //assertion
      try {             
        	 String TaskList = "resourceId(\"tasksList\")";      
             driver.findElements(MobileBy.AndroidUIAutomator(TaskList));;
             System.out.println("All the added task cleared successfully and test case passed");
         } 
      catch (NoSuchElementException e) {
             System.out.println(e.getMessage());
         }
      
      
      
	  
     
  }
  @AfterClass
  public void tearDown() throws InterruptedException {
  	  Thread.sleep(3000);
        driver.quit();
  }
}
