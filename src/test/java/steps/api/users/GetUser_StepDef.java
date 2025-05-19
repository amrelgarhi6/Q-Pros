package steps.api.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.api.users.GetUser.*;

public class GetUser_StepDef {

    @When("User sends a GET request to retrieve a user with valid request")
    public void userSendsAGETRequestToRetrieveAUserWithValidRequest() {
        invokeGetUserEndpointWithValidKey();
    }

    @And("the response should contain user info")
    public void theResponseShouldContainUserInfo() {
        assertResponsePayloadContainsCorrectParameters();
    }

    @When("the user sends a GET request to invalid username")
    public void theUserSendsAGETRequestToInvalidUsername() {
        invokeGetUserEndpointWithInValidKey();
    }

}