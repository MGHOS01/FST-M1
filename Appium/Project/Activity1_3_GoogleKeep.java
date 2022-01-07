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

public class Activity1_3_GoogleKeep {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	@BeforeClass
   public void beforeClass() throws MalformedURLException {
       // Set the Desired Capabilities
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("deviceId", "a054105c");
       caps.setCapability("deviceName", "Trisha's");
       caps.setCapability("platformName", "Android");
       caps.setCapability("appPackage", "com.google.android.keep");
       caps.setCapability("appActivity", ".activities.BrowseActivity");
       caps.setCapability("noReset", true);

       // Instantiate Appium Driver
       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
       driver = new AndroidDriver<MobileElement>(appServer, caps);
       wait = new WebDriverWait(driver, 5);
	}
  @Test
  public void addNote_GoolgleNote() throws InterruptedException {
	  MobileElement addNote = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]");
	  addNote.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
	  String Title = "resourceId(\"com.google.android.keep:id/editable_title\")";	  
	  MobileElement NewTitle = driver.findElement(MobileBy.AndroidUIAutomator(Title));
	  NewTitle.sendKeys("Appium Testing");
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/edit_note_text")));
	  String Text = "resourceId(\"com.google.android.keep:id/edit_note_text\")";	  
	  MobileElement NewText = driver.findElement(MobileBy.AndroidUIAutomator(Text));
	  NewText.sendKeys("We are learning mobile testing using Appium tool ");
	  MobileElement Reminder = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]");
	  Reminder.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/dialog_title")));
	  MobileElement timeSlot =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '8:00 am')]"));
	  timeSlot.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/text")));
	  MobileElement Time =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Afternoon')]"));
	  Time.click();
	  Thread.sleep(300);
	  driver.findElementById("com.google.android.keep:id/save").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
	  MobileElement Back = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	  Back.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
	  MobileElement NavigationDrawer = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
	  NavigationDrawer.click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/drawer_navigation_reminders")));
	  MobileElement ReminderNavigation = driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders");
	  ReminderNavigation.click();
	  MobileElement Note =driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Appium Testing')]"));
	  String NoteTitle = Note.getText();
	  Assert.assertEquals(NoteTitle, "Appium Testing");
	  
	  
	  
  }
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}
