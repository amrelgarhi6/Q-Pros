package steps.web;

import io.cucumber.java.en.Then;

import static pages.web.checkoutPage.assertBillingFormDisplayed;

public class checkoutPage_StepDef {



    @Then("User should see the Billing Details form")
    public void userShouldSeeBillingForm() {
        assertBillingFormDisplayed();
    }

}
