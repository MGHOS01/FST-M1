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

public class Activity3_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a054105c");
        caps.setCapability("deviceName", "Trisha's");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", ".ui.MmsTabActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
    	driver.findElement(MobileBy.AndroidUIAutomator("description(\"Compose\")")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.android.mms:id/recipient_rows")));
        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.android.mms:id/recipients_editor\")";        
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("8250583854");

        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();

        // Type in a message
        messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");

        // Send the message
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send message\")")).click();
        String SelectSIMCard = "resourceId(\"com.android.mms:id/tv_title\")";
        driver.findElement(MobileBy.AndroidUIAutomator(SelectSIMCard)).click();
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send message\")")).click();
        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_body")));

        // Assertion
        String messageLocator = "resourceId(\"com.android.mms:id/message_body\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
