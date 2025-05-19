@Regression @API_Regression
Feature: Test User CRUD operations on Petstore API for user/Endpoint

  #################################################
    #          END-TO-END SCENARIO
  #################################################
  @E2E_Req
  Scenario: End-to-End User lifecycle (Create → Read → Update → Delete) for user/Endpoint
    Given the user sends a valid POST request to the user endpoint
    Then API response status code should be SC_CREATED.
    And the response should contain user details
    When User sends a GET request to retrieve a user with valid request
    Then API response status code should be SC_OK.
    And the response should contain user info
    When the user sends a valid PUT request to update the email and phone
    Then API response status code should be SC_OK.
    And the updated user info should reflect the changes
    When the user sends a DELETE request to "New user101"
    Then API response status code should be SC_OK.
    And the user should no longer be retrievable

