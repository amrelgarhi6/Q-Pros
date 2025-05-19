@Regression @Regression_FE
Feature: E2E Shopping flow for buying a new bool

  As a user
  I want to browse and purchase a book
  So that I can buy this book and fill payment form

  Background:
    Then Validate that user lands on website

  Scenario Outline: Validate adding a book to cart and proceed to checkout
    Then User should see the book "<bookTitle>" with price "<price>"
    When User selects book "<bookTitle>" upon clicking on "Add to basket"
    Then User should see a success message indicating the book was added to the basket
    When User clicks on the Shopping Cart icon
    Then User should see "<bookTitle>" in the cart with price "<price>"
    When User clicks on the Proceed to Checkout button
    Then User should see the Billing Details form

    Examples:
      | bookTitle            | price  |
      | Thinking in HTML     | 400.00 |
      | Mastering JavaScript | 350.00 |
      | Selenium Ruby        | 500.00 |


