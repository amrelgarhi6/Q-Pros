@Regression @API_Regression
Feature: Test Create User/Endpoint operation on Petstore API

  #################################################
  # CREATE - Negative
  #################################################
  @invalid_Post_Req
  Scenario: Validate POST /user fails with missing body in request
    Given the user sends a POST request with invalid request body
    Then API response status code should be SC_BAD_REQUEST.
    And  API response payload should contains invalid bad request error message.



