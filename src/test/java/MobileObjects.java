import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    public WebElement btn2;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    public WebElement btnAdd;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    public WebElement btnEquals;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public WebElement result;

    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
