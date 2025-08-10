import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NetologyAppTest {

    private AndroidDriver driver;
    private NetologyObjects netologyObjects;

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
        desiredCapabilities.setCapability("appium:deviceName", "name");
        desiredCapabilities.setCapability("appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("noReset", false);

        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        driver = new AndroidDriver(this.getUrl(), desiredCapabilities);

        netologyObjects = new NetologyObjects(driver);
    }

    @Test
    public void UiAutomatorEmptyInputTest() {
        netologyObjects.userInput.isDisplayed();
        netologyObjects.userInput.sendKeys("   ");

        netologyObjects.btnChangeText.isDisplayed();
        netologyObjects.btnChangeText.click();

        netologyObjects.changedText.isDisplayed();
        Assertions.assertEquals("Hello UiAutomator!", netologyObjects.changedText.getText());
    }

    @Test
    public void UiAutomatorChangeTextTest() {
        netologyObjects.userInput.isDisplayed();
        netologyObjects.userInput.sendKeys("Hello, world!");

        netologyObjects.btnNewActivity.isDisplayed();
        netologyObjects.btnNewActivity.click();

        netologyObjects.newActivityText.isDisplayed();
        Assertions.assertEquals("Hello, world!", netologyObjects.newActivityText.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


