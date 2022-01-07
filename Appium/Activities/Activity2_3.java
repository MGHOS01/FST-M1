import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity2_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	 DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("deviceId", "a054105c");
         caps.setCapability("deviceName", "Trisha's");
         caps.setCapability("platformName", "Android");
         caps.setCapability("appPackage", "com.android.contacts");
         caps.setCapability("appActivity", ".activities.TwelveKeyDialer");
         caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addContact() {
    	//opening contact page
    	MobileElement ContactsPage = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Contacts\"]");
    	ContactsPage.click();
        // Click on add new contact floating button
    	MobileElement AddButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Add\"]");
        AddButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Name']")));
        
        // Find the first name, last name, and phone number fields
       // driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Collapse name\"]").click();        
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='Name']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        
        // Enter the text in the fields
        firstName.sendKeys("Aaditya Verma");
        phoneNumber.sendKeys("9991284782");
        
        // Save the contact
        driver.findElementByXPath("//android.widget.Button[@content-desc=\"OK\"]").click();
        
        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("custom_title")));

        // Assertion
        MobileElement mobileCard = driver.findElementById("custom_title");
        Assert.assertTrue(mobileCard.isDisplayed());        
        
        String ContactName = driver.findElementById("custom_title").getText();
        Assert.assertEquals(ContactName, "Aaditya Verma");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
