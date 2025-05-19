package steps.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.mobile.weatherHomePage.*;

public class weatherHomePage_StepDef {



    @Then("Validate that user lands on weather home screen")
    public void validateThatUserLandsOnWeatherHomeScreen() {
        assertLandingOnWeatherMainScreen();
    }

    @When("User navigates to Settings")
    public void userNavigatesToSettings() {
        clickOnBurgerMenu();
    }

    @And("User select {string} option from burger menu setting")
    public void userSelectOptionFromBurgerMenuSetting(String menuOptionText) {
        selectFromBurgerMenuOptions(menuOptionText);
    }

    @When("User change temperature unit to {string}")
    public void userChangeTemperatureUnitTo(String tempUnit) {
        selectTempUnit(tempUnit);
    }

    @And("User clicks on Done CTA")
    public void userClicksOnDoneCTA() {
        submitChangeUnitSettings();
    }

    @And("Validate that main screen should display temperature in {string}")
    public void validateThatMainScreenShouldDisplayTemperatureIn(String unit) {
        assertTemperatureUnitOnHomeScreen(unit);
    }

    @Then("Validate that temperature unit reflected on burger menu side-menu with {string}")
    public void validateThatTemperatureUnitReflectedOnBurgerMenuSideMenuWith(String unitTemp) {
        assertTemperatureUnitOnBurgerMenu(unitTemp);
    }

    @And("User changes time format to {string}")
    public void userChangesTimeFormatTo(String arg0) {
    }

    @Then("Validate that main screen should display time in {string} format")
    public void validateThatMainScreenShouldDisplayTimeInFormat(String arg0) {
    }

    @Then("Each of the next {int} forecast hours should display rain and humidity icons")
    public void eachOfTheNextForecastHoursShouldDisplayRainAndHumidityIcons(int arg0) {
    }
}
