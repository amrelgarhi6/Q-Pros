package steps.api.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.api.users.PutUser.*;
import static pages.api.users.PutUser.invokePutUserEndpointWithInValidKey;

public class PutUser_StepDef {

    @When("the user sends a valid PUT request to update the email and phone")
    public void theUserSendsAValidPUTRequestToUpdateTheEmailAndPhone() {
        invokePutUserEndpointWithValidKey();
    }

    @And("the updated user info should reflect the changes")
    public void theUpdatedUserInfoShouldReflectTheChanges() {
        assertResponsePayloadUpdatedCorrectly();
    }

    @When("the user sends a PUT request to invalid username")
    public void theUserSendsAPUTRequestToInvalidUsername() {
        invokePutUserEndpointWithInValidKey();
    }
}