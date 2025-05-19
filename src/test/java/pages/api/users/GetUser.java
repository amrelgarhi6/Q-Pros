package pages.api.users;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.context.Context;
import api.context.ScenarioContext;
import api.pojo.responses.Users.GetUsers_Res;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utiltites.assertions.Assertions;
import utiltites.readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Map;

public class GetUser {
    private static Response response;


    private static final Map<String, String> queryParam = new HashMap<>();
    private final static String jsonFilePath = ("src/test/resources/test_data/api/response/Users/GetUser.json");



    private static final String id = JSONDataManager.getJSONData(jsonFilePath, "id", JSONDataManager.Types.STRING).toString();
    private static final String username = JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString();
    private static final String firstname = JSONDataManager.getJSONData(jsonFilePath, "firstName", JSONDataManager.Types.STRING).toString();
    private static final String lastname = JSONDataManager.getJSONData(jsonFilePath, "lastName", JSONDataManager.Types.STRING).toString();
    private static final String email = JSONDataManager.getJSONData(jsonFilePath, "email", JSONDataManager.Types.STRING).toString();
    private static final String password = JSONDataManager.getJSONData(jsonFilePath, "password", JSONDataManager.Types.STRING).toString();
    private static final String phone = JSONDataManager.getJSONData(jsonFilePath, "phone", JSONDataManager.Types.STRING).toString();
    private static final String userStatus = JSONDataManager.getJSONData(jsonFilePath, "userStatus", JSONDataManager.Types.STRING).toString();

    public static void invokeGetUserEndpointWithValidKey() {
        String userName_Param = ScenarioContext.getContext(Context.USER_NAME).toString();
        queryParam.put("username",userName_Param);

        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.GET)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.GET_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeGetUserEndpointWithInValidKey() {

        queryParam.put("username","WRONG");

        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.GET)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.GET_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsCorrectParameters()
    {
        GetUsers_Res getUserRes = response.as(new TypeRef<>() {});

        Assertions.hardAssert().assertNotNull(getUserRes.getId());
        Assertions.hardAssert().assertNotNull(getUserRes.getUsername());
        Assertions.hardAssert().assertNotNull(getUserRes.getFirstName());
        Assertions.hardAssert().assertNotNull(getUserRes.getLastName());
        Assertions.hardAssert().assertNotNull(getUserRes.getEmail());
        Assertions.hardAssert().assertNotNull(getUserRes.getPassword());
        Assertions.hardAssert().assertNotNull(getUserRes.getPhone());
        Assertions.hardAssert().assertNotNull(getUserRes.getUserStatus());

        Assertions.hardAssert().objectEquals(getUserRes.getId(),id);
        Assertions.hardAssert().objectEquals(getUserRes.getUsername(),username);
        Assertions.hardAssert().objectEquals(getUserRes.getFirstName(),firstname);
        Assertions.hardAssert().objectEquals(getUserRes.getLastName(),lastname);
        Assertions.hardAssert().objectEquals(getUserRes.getEmail(),email);
        Assertions.hardAssert().objectEquals(getUserRes.getPassword(),password);
        Assertions.hardAssert().objectEquals(getUserRes.getPhone(),phone);
        Assertions.hardAssert().objectEquals(getUserRes.getUserStatus(),userStatus);
    }
}