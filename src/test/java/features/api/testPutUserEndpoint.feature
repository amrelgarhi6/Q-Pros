@Regression @API_Regression
Feature: Test Put User/Endpoint operation on Petstore API


  #################################################
  #  UPDATE - Negative
  #################################################
  Scenario: Validate PUT /user/{username} fails with invalid update data
    When the user sends a PUT request to invalid username
    Then API response status code should be SC_BAD_REQUEST.
