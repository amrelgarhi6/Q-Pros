package mobile.driver;

import com.google.common.collect.ImmutableMap;
import utiltites.exceptions.Exceptions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class DriverManager {
    public DriverManager() {
    }

    public static Android androidDriver() {
        return new Android();
    }
}