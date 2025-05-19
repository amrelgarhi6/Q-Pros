package pages.web;

import org.openqa.selenium.By;
import utiltites.assertions.Assertions;
import web.utilities.actions.ElementActions;

public class checkoutPage {


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////  Locators  ///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static By proceedToCheckoutBtn = By.xpath("//a[contains(@class,'checkout-button')]");
    private final static By billingForm = By.cssSelector("form.checkout");


    public static void clickProceedToCheckout() {
        ElementActions.click(proceedToCheckoutBtn);
    }

    public static void assertBillingFormDisplayed() {
        Assertions.hardAssert().elementDisplayed(billingForm);
    }
}
