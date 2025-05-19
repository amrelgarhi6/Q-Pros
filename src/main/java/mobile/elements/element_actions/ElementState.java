package mobile.elements.element_actions;

import mobile.driver.DriverManager;
import mobile.elements.Elements;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import utiltites.logger.Log4JLogger;
import org.openqa.selenium.By;

public class ElementState {
    public ElementState() {
    }

    public boolean isClickable(@NotNull final By elementLocated) {
        boolean isClickable = Elements.elementActions().getAttribute(elementLocated, "clickable").equals("true");
        Log4JLogger.logINFO(getClass(), new Object() {}.getClass().getEnclosingMethod().getName(), "Is element clickable: " + isClickable);
        return isClickable;
    }

    public boolean isSelected(@NotNull final By elementLocated) {
        boolean isSelected = Elements.elementActions().findElement(elementLocated).isSelected();
        Log4JLogger.logINFO(getClass(), new Object() {}.getClass().getEnclosingMethod().getName(), "Is element selected: " + isSelected);
        return isSelected;
    }
}