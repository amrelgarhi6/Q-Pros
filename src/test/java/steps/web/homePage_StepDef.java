package steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.web.homePage.*;

public class homePage_StepDef {

    @Then("Validate that user lands on website")
    public void validateThatUserLandsOnWebsite() {
        assertLandingHomePage();
    }

    @Then("User should see the book {string} with price {string}")
    public void userShouldSeeTheBookWithPrice(String title, String price) {
        assertBookIsDisplayed(title, price);
    }

    @When("User selects book {string} upon clicking on {string}")
    public void userSelectsBookUponClickingOn(String bookName, String actionName) {
        clickAddToBasket(bookName, actionName);
    }

    @Then("User should see a success message indicating the book was added to the basket")
    public void userShouldSeeSuccessMessage() {
        assertSuccessMessageDisplayed();
    }

    @When("User clicks on the Shopping Cart icon")
    public void userClicksOnCart() {
        clickCartIcon();
    }


}
