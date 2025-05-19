package steps.api.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.api.users.DeleteUser.invokeDeleteUserEndpointWithInValidKey;
import static pages.api.users.DeleteUser.invokeDeleteUserEndpointWithValidKey;
import static pages.api.users.PutUser.assertResponsePayloadUpdatedCorrectly;
import static pages.api.users.PutUser.invokePutUserEndpointWithValidKey;

public class DeleteUser_StepDef {

    @When("the user sends a DELETE request to {string}")
    public void theUserSendsADELETERequestTo(String userNAme) {
        invokeDeleteUserEndpointWithValidKey(userNAme);
    }

    @And("the user should no longer be retrievable")
    public void theUserShouldNoLongerBeRetrievable() {
    }

    @When("the user sends a DELETE request to invalid username")
    public void theUserSendsADELETERequestToInvalidUsername() {
        invokeDeleteUserEndpointWithInValidKey();
    }
}