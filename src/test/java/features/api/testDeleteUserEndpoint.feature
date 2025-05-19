@Regression @API_Regression
Feature: Test Delete User/Endpoint operation on Petstore API


  #################################################
#  DELETE - Negative
  #################################################
  Scenario: Validate DELETE /user/{username} fails for non-existent users
    When the user sends a DELETE request to invalid username
    Then API response status code should be SC_BAD_REQUEST.



