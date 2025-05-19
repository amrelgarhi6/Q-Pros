package mobile.elements.element_actions;

import utiltites.exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiltites.waits.Waits;

import static mobile.driver.DriverInitializer.driver;

public class MobileElementActions {
    public MobileElementActions() {
    }


    public WebElement findElement(@NotNull final By elementLocated) {
        WebElement element = null;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            element = driver.findElement(elementLocated);
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return element;
    }

    public MobileElementActions click(@NotNull final By elementLocated) {
        try {
            findElement(elementLocated).click();
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public MobileElementActions sendKeys(@NotNull final By elementLocated, @NotNull final String keyToSend) {
        try {
            findElement(elementLocated).sendKeys(keyToSend);
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public String getText(@NotNull final By elementLocated) {
        String elementText = null;
        try {
            elementText = findElement(elementLocated).getText();
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return elementText;
    }

    public String getAttribute(@NotNull final By elementLocated, @NotNull final String attribute) {
        String attributeValue = null;
        try {
            attributeValue = findElement(elementLocated).getAttribute(attribute);
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return attributeValue;
    }
}