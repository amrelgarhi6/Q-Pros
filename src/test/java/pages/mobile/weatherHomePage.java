package pages.mobile;

import mobile.elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiltites.assertions.Assertions;
import web.utilities.driver_manager.DriverManager;

import java.util.List;

public class weatherHomePage {
    private static final By weatherMainScreen = By.id("com.wftab.weather.forecast:id/currently_weather");

    private static final By temperatureUnitText = By.id("com.wftab.weather.forecast:id/tv_temperature_unit");
    private static final By burgerMenu = By.id("com.wftab.weather.forecast:id/iv_nav_menu");
    private static final By burgerMenuTempUnit = By.id("com.wftab.weather.forecast:id/tv_temp_unit");
    private static final By doneButton = By.id("com.wftab.weather.forecast:id/tv_done");
    private static final By forecastContainer = By.id("com.weatherapp:id/forecast_container");
    private static By burgerMenuOptions(String menuOptionText) {return By.id("//*[@text='" + menuOptionText + "']");}
    private static By temperatureUnitOptions(String tempUnit) {return By.xpath("//*[contains(@resource-id,'com.wftab.weather.forecast:id/tv_toggle') and @text='" + tempUnit + "']");}

    public static void clickOnBurgerMenu() {
        Elements.elementActions().click(burgerMenu);
    }

    public static void submitChangeUnitSettings() {
        Elements.elementActions().click(doneButton);
    }

    public static void selectTempUnit(String tempUnit) {
        Elements.elementActions().click(temperatureUnitOptions(tempUnit));
    }

    public static void selectFromBurgerMenuOptions(String menuOptionText) {
        Elements.elementActions().click(burgerMenuOptions(menuOptionText));
    }


    public static void assertTemperatureUnitOnHomeScreen(String unit) {
        Assertions.hardAssert().elementTextContains(temperatureUnitText, unit);
    }

    public static void assertTemperatureUnitOnBurgerMenu(String unit) {
        Assertions.hardAssert().elementTextContains(burgerMenuTempUnit, unit);
    }

    public static void assertLandingOnWeatherMainScreen() {
        Assertions.hardAssert().elementDisplayed(weatherMainScreen);
    }

    public static void assertTimeFormat(String format) {
        String timeText = Elements.elementActions().getText(By.id(""));
        boolean is12Hour = timeText.toLowerCase().contains("am") || timeText.toLowerCase().contains("pm");
        Assertions.hardAssert().assertTrue(format.equals("12-hour") == is12Hour, "Time format mismatch.");
    }

    public static void getNextSixHourForecasts() {
        List<WebElement> forecastCards = DriverManager.getDriver().findElements(forecastContainer);

        for (int i = 0; i < 6 && i < forecastCards.size(); i++) {
            WebElement card = forecastCards.get(i);
        }
    }

}
