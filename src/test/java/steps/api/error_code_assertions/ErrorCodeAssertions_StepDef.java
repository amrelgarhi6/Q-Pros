package steps.api.error_code_assertions;

import io.cucumber.java.en.And;
import io.restassured.response.Response;
import pages.api.error_code_assertions.ErrorCodeAssertions;
import api.context.ScenarioContext;
import api.context.Context;

public class ErrorCodeAssertions_StepDef {
    /**
     * SC_BAD_REQUEST = 400
     **/
    @And("API response payload should contains invalid bad request error message.")
    public void apiResponsePayloadShouldContainsInvalidBadRequestErrorMessage() {
        ErrorCodeAssertions.apiResponsePayloadShouldContainsInvalidBadRequestErrorMessage((Response) ScenarioContext.getContext(Context.RESPONSE_PAYLOAD));
    }

    /**
     * SC_UNAUTHORIZED = 401
     **/
    @And("API response payload should contains an invalid unauthorized error message.")
    public void apiResponsePayloadShouldContainsInvalidUnauthorizedErrorMessage() {
        ErrorCodeAssertions.apiResponsePayloadShouldContainsInvalidUnauthorizedErrorMessage((Response) ScenarioContext.getContext(Context.RESPONSE_PAYLOAD));
    }

    /**
     * SC_FORBIDDEN = 403
     **/
    @And("API response payload should contains an invalid forbidden error message.")
    public void apiResponsePayloadShouldContainsInvalidForbiddenErrorMessage() {
        ErrorCodeAssertions.apiResponsePayloadShouldContainsInvalidForbiddenErrorMessage((Response) ScenarioContext.getContext(Context.RESPONSE_PAYLOAD));
    }

    /**
     * SC_NOT_FOUND = 404
     **/
    @And("API response payload should contains an invalid not found error message.")
    public void apiResponsePayloadShouldContainsInvalidNotFoundErrorMessage() {
        ErrorCodeAssertions.apiResponsePayloadShouldContainsInvalidNotFoundErrorMessage((Response) ScenarioContext.getContext(Context.RESPONSE_PAYLOAD));
    }

    /**
     * SC_NOT_FOUND = 505
     **/
    @And("API response payload should contains an internal server error message.")
    public void apiResponsePayloadShouldContainsServerErrorMessage() {
        ErrorCodeAssertions.apiResponsePayloadShouldContainsServerErrorMessage((Response) ScenarioContext.getContext(Context.RESPONSE_PAYLOAD));
    }
}