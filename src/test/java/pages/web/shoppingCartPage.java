package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiltites.assertions.Assertions;
import web.utilities.driver_manager.DriverManager;

import java.util.*;

import static web.utilities.actions.ElementActions.parseLastPriceFromText;


public class shoppingCartPage {


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////  Locators  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static By cartBooksTitle = By.xpath("//*[@class='product-name']/a");
    private final static By cartBooksPrice = By.xpath("//td[@class='product-subtotal']//span[@class='woocommerce-Price-amount amount']");


    public static void assertCartContainsBook(String expectedTitle, String expectedPrice) {

        List<WebElement> cartBookTitle = DriverManager.getDriver().findElements(cartBooksTitle);
        List<WebElement> cartBookPrice = DriverManager.getDriver().findElements(cartBooksPrice);

        for (int i = 0; i < cartBookTitle.size(); i++) {
            String actualTitle = cartBookTitle.get(i).getText().trim();
            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                String actualPrice = cartBookPrice.get(i).getText().trim();

                Assertions.hardAssert().objectEquals(parseLastPriceFromText(actualPrice), parseLastPriceFromText(expectedPrice));
            }}}
}
