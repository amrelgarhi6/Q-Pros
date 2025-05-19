package mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile.elements.Elements;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import utiltites.logger.Log4JLogger;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.*;
import utiltites.readers.properties_reader.PropertiesConfigurations;
import utiltites.waits.Waits;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverInitializer extends AbstractTestNGCucumberTests {
    @Setter
    @Getter
    public static String Platform;
public static AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Pixel9")
                .setPlatformName("Android")
                .setAppPackage("com.wftab.weather.forecast")
                .setAppActivity("com.tohsoft.weather.ui.main.MainActivity")
                .setAutomationName("UiAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(300))
                .setAutoGrantPermissions(true)
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}