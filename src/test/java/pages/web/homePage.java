package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiltites.assertions.Assertions;
import web.utilities.actions.ElementActions;
import web.utilities.driver_manager.DriverManager;

import java.util.List;

import static web.utilities.actions.ElementActions.parseLastPriceFromText;

public class homePage {

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// //////////////////////////////////////////  Locators  ///////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static By homePageTitle = By.xpath("//*[@title='Automation Practice Site']/span");
    private final static By booksTitle = By.xpath("//ul[@class='products']//h3");
    private final static By booksPrice = By.cssSelector("span.price");
    private final static By successAddedToBasketMessage = By.xpath("//*[@title='View Basket']");
    private final static By cartIcon = By.xpath("//*[@title='View your shopping cart']");
    private static By addToBasketBtn(String bookName, String actionName) {return By.xpath("//h3[text()='" + bookName + "']/ancestor::li//a[contains(text(),'" + actionName + "')]");}

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// //////////////////////////////////////////  Actions  ////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void assertBookIsDisplayed(String expectedTitle, String expectedPrice) {
        List<WebElement> productTitles = DriverManager.getDriver().findElements(booksTitle);
        List<WebElement> productPrices = DriverManager.getDriver().findElements(booksPrice);

        boolean found = false;

        for (int i = 0; i < productTitles.size(); i++) {
            String actualTitle = productTitles.get(i).getText().trim();
            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                String actualPrice = productPrices.get(i).getText().trim();

                Assertions.hardAssert().objectEquals(parseLastPriceFromText(actualPrice), parseLastPriceFromText(expectedPrice));
                found = true;
                break;
            }
        }

        // Final assertion if the book was never found
        Assertions.hardAssert().assertTrue(found, "❌ Book with title '" + expectedTitle + "' was not found!");
    }


    public static void clickAddToBasket(String bookName, String actionName) {
        ElementActions.click(addToBasketBtn(bookName, actionName));
    }

    public static void assertSuccessMessageDisplayed() {
        Assertions.hardAssert().elementDisplayed(successAddedToBasketMessage);
        Assertions.hardAssert().elementTextContains(successAddedToBasketMessage, "View Basket");
    }

    public static void clickCartIcon() {
        ElementActions.click(cartIcon);
    }


    public static void assertLandingHomePage() {
        Assertions.hardAssert().elementDisplayed(homePageTitle);
    }


}
