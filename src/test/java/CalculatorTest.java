import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


public class CalculatorTest {

    enum Platform {Android, IOS}
    private AndroidDriver driver;
    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "some name");
        desiredCapabilities.setCapability("appium:packageName", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:activityName", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        driver = new AndroidDriver(this.getUrl(), desiredCapabilities);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void sampleTest() {
        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnAdd.isDisplayed();
        mobileObjects.btnAdd.click();

        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnEquals.isDisplayed();
        mobileObjects.btnEquals.click();

        mobileObjects.result.isDisplayed();
        Assertions.assertEquals("4", mobileObjects.result.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

