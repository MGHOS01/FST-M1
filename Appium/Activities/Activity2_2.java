import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_2 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a054105c");
        caps.setCapability("deviceName", "Trisha's");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void add() {
    	driver.findElementById("android:id/button2").click();
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_plus_s").click();
        driver.findElementById("btn_9_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        MobileElement result = driver.findElementByXPath("//android.widget.TextView[contains(@text, '= 14')]");
        //String result = driver.findElementById("result").getText();
        String addResult = result.getText();
        System.out.println(addResult);
        Assert.assertEquals(addResult, "= 14");
        driver.findElementById("btn_c_s").click();
    }
    
    @Test
    public void subtract() {
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_minus_s").click();
        driver.findElementById("btn_5_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        MobileElement result1 = driver.findElementByXPath("//android.widget.TextView[contains(@text, '= 5')]");
        String subResult = result1.getText();
        System.out.println(subResult);
        Assert.assertEquals(subResult, "= 5");
        driver.findElementById("btn_c_s").click();
    }

    @Test
    public void multiply() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_mul_s").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        MobileElement result2 = driver.findElementByXPath("//android.widget.TextView[contains(@text, '= 500')]");
        String mulResult = result2.getText();
        System.out.println(mulResult);
        Assert.assertEquals(mulResult, "= 500");
        driver.findElementById("btn_c_s").click();
    }

    @Test
    public void divide() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("btn_2_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        MobileElement result3 = driver.findElementByXPath("//android.widget.TextView[contains(@text, '= 25')]");
        String divResult = result3.getText();
        System.out.println(divResult);
        Assert.assertEquals(divResult, "= 25");
        driver.findElementById("btn_c_s").click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
