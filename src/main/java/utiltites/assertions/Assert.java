package utiltites.assertions;

import mobile.elements.Elements;
import org.openqa.selenium.WebElement;
import utiltites.exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.response.Response;
import utiltites.logger.Log4JLogger;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;
import web.utilities.driver_manager.DriverManager;

import static web.utilities.driver_manager.DriverManager.driver;

public class Assert {
    public Assert() {
    }

    public Assert elementDisplayed(@NotNull final By elementLocated) {
        try {
            WebElement element = DriverManager.getDriver().findElement(elementLocated);
            new Assertion().assertTrue(element.isDisplayed(), "Element located with {" + elementLocated.toString() + "} is not displayed");
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementNotDisplayed(@NotNull final By elementLocated) {
        try {
            WebElement element = DriverManager.getDriver().findElement(elementLocated);
            new Assertion().assertFalse(element.isDisplayed(), "Element located with {" + elementLocated.toString() + "} is displayed");
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementTextContains(@NotNull final By elementLocated, final String expectedText) {
        try {
            new Assertion().assertTrue(Elements.elementActions().getText(elementLocated).trim().contains(expectedText.trim()));
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} contains the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            new Assertion().assertEquals(actual, expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual {" + actual + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectContains(@NotNull final Object actual,@NotNull final Object expected) {
        try {
            new Assertion().assertTrue(actual.toString().contains(expected.toString()));
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual {" + actual + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertTrue(@NotNull final boolean condition, String s) {
        try {
            new Assertion().assertTrue(condition);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertNotNull(@NotNull final Object expected) {
        try {
            new Assertion().assertNotNull(expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert responseStatusCodeEquals(@NotNull final Response response, @NotNull final StatusCode statusCode) {
        try {
            switch (statusCode) {
                case SC_OK -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {200 SC_OK}");
                }
                case SC_CREATED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {201 SC_CREATED}");
                }
                case SC_ACCEPTED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_ACCEPTED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {202 SC_ACCEPTED}");
                }
                case SC_BAD_REQUEST -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {400 SC_CREATED}");
                }
                case SC_UNAUTHORIZED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {401 SC_UNAUTHORIZED}");
                }
                case SC_FORBIDDEN -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_FORBIDDEN);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {403 SC_FORBIDDEN}");
                }
                case SC_NOT_FOUND -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {404 SC_NOT_FOUND}");
                }
            }
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
}