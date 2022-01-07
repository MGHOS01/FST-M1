package Appium_Live_Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1_1GoogleTasks {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	@BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a054105c");
        caps.setCapability("deviceName", "Trisha's");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
  @Test
  public void addTask_googleTask() throws InterruptedException {
	  MobileElement addTask = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]");
	  addTask.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  String Task1 = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";	  
	  MobileElement NewTask1 = driver.findElement(MobileBy.AndroidUIAutomator(Task1));
	  NewTask1.sendKeys("Complete Activity with Google Tasks");
	  Thread.sleep(1000);
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  addTask.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  String Task2 = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";	  
	  MobileElement NewTask2 = driver.findElement(MobileBy.AndroidUIAutomator(Task2));
	  NewTask2.sendKeys("Complete Activity with Google Keep");
	  Thread.sleep(1000);
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  addTask.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  String Task3 = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";	  
	  MobileElement NewTask3 = driver.findElement(MobileBy.AndroidUIAutomator(Task3));
	  NewTask3.sendKeys("Complete the second Activity Google Keep");
	  Thread.sleep(1000);
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  
	  MobileElement addedTask1 =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Complete the second Activity Google Keep')]"));
	  String addTask1 = addedTask1.getText();
	  Assert.assertEquals(addTask1, "Complete the second Activity Google Keep");
	  MobileElement addedTask2 =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Complete Activity with Google Keep')]"));
	  String addTask2 = addedTask2.getText();
	  Assert.assertEquals(addTask2, "Complete Activity with Google Keep");
	  MobileElement addedTask3 =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Complete Activity with Google Tasks')]"));
	  String addTask3 = addedTask3.getText();
	  Assert.assertEquals(addTask3, "Complete Activity with Google Tasks");
  }
  @AfterClass
  public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
     driver.quit();
  }
}
