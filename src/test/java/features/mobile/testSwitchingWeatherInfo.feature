@Regression @Mobile_Regression
Feature: Validate switching Weather info [Temperature - time format] Functionality and chance of raining

  As a user,
  I want to customize the display settings
  So that I can view temperature, time info in my preferred format


  Scenario: Validate Change temperature unit from Celsius to Fahrenheit
    Then Validate that user lands on weather home screen
    When User navigates to Settings
    And  User select "Unit setting" option from burger menu setting
    When User change temperature unit to "°F"
    And  User clicks on Done CTA
    Then Validate that temperature unit reflected on burger menu side-menu with "°F"
    And  User select "Home" option from burger menu setting
    Then Validate that user lands on weather home screen
    And  Validate that main screen should display temperature in "°F"

  Scenario: Validate Change time format from 24-hour to 12-hour
    When User navigates to Settings
    And User changes time format to "12-hour"
    Then Validate that main screen should display time in "AM/PM" format

  Scenario: Validate rain chance and humidity for next 6 hours
    Then Each of the next 6 forecast hours should display rain and humidity icons
