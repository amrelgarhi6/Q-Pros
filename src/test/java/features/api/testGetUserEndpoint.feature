@Regression @API_Regression
Feature: Test Get User/Endpoint operation on Petstore API


  #################################################
#   READ - Negative
  #################################################
  Scenario: Validate GET /user/{username} fails for invalid usernames
    When the user sends a GET request to invalid username
    Then API response status code should be SC_BAD_REQUEST.