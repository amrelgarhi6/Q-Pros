package steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.web.checkoutPage.clickProceedToCheckout;
import static pages.web.shoppingCartPage.assertCartContainsBook;

public class cartPage_StepDef {


    @Then("User should see {string} in the cart with price {string}")
    public void userShouldSeeBookInCart(String title, String price) {
        assertCartContainsBook(title, price);
    }

    @When("User clicks on the Proceed to Checkout button")
    public void userClicksProceedToCheckout() {
        clickProceedToCheckout();
    }

}
