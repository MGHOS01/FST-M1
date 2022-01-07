package Appium_Live_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_3_1Popups_CorrectCredential {
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
public void LoginForm_InCorrectCredentials() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //opening the URL
      driver.get("https://www.training-support.net/selenium");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Scrolling
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollDescriptionIntoView(\"Popups Tooltips and Modals\")")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //SignIN
      MobileElement SigninButton =driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Sign In')]"));
      SigninButton.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Login
      String UserName = "resourceId(\"username\")";
      driver.findElement(MobileBy.AndroidUIAutomator(UserName)).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      UserName = "resourceId(\"username\")";
      MobileElement addUsername = driver.findElement(MobileBy.AndroidUIAutomator(UserName));
      addUsername.sendKeys("admin");
      String Password = "resourceId(\"password\")";
      driver.findElement(MobileBy.AndroidUIAutomator(Password)).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Password = "resourceId(\"password\")";
      MobileElement addPassword = driver.findElement(MobileBy.AndroidUIAutomator(Password));
      addPassword.sendKeys("password");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      MobileElement LoginButton =driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Log in')]"));
      LoginButton.click();
      //Assertion
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      MobileElement confirmation =driver.findElement(By.xpath("//android.view.View[contains(@text, 'Welcome Back, admin')]"));;
 	  String ActionConfirmation = confirmation.getText();
 	  Assert.assertEquals(ActionConfirmation, "Welcome Back, admin");
	}
@AfterClass
public void tearDown() throws InterruptedException {
	  Thread.sleep(3000);
      driver.quit();
}
}