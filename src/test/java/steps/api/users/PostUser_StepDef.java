package steps.api.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static pages.api.users.PostUser.*;

public class PostUser_StepDef {

    @Given("the user sends a valid POST request to the user endpoint")
    public void theUserSendsAValidPOSTRequestToTheUserEndpoint() {
        invokePostUserEndpointWithValidKey();
    }

    @And("the response should contain user details")
    public void theResponseShouldContainUserDetails() {
        assertResponsePayloadContainsCorrectParameters();
    }

    @Given("the user sends a POST request with invalid request body")
    public void theUserSendsAPOSTRequestWithInvalidRequestBody() {
        invokePostUserEndpointWithInValidKey();
    }
}