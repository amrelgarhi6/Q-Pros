package pages.api.users;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.context.Context;
import api.context.ScenarioContext;
import api.pojo.requests.Users.PostUsers_Req;
import api.pojo.responses.Users.PostUsers_Res;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utiltites.assertions.Assertions;
import utiltites.logger.Log4JLogger;
import org.apache.http.HttpStatus;
import utiltites.readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Map;

public class PostUser {

    private final static String jsonFilePath = ("src/test/resources/test_data/api/request/Users/PostUser.json");

    private static final String id = JSONDataManager.getJSONData(jsonFilePath, "id", JSONDataManager.Types.STRING).toString();
    private static final String username = JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString();
    private static final String firstname = JSONDataManager.getJSONData(jsonFilePath, "firstName", JSONDataManager.Types.STRING).toString();
    private static final String lastname = JSONDataManager.getJSONData(jsonFilePath, "lastName", JSONDataManager.Types.STRING).toString();
    private static final String email = JSONDataManager.getJSONData(jsonFilePath, "email", JSONDataManager.Types.STRING).toString();
    private static final String password = JSONDataManager.getJSONData(jsonFilePath, "password", JSONDataManager.Types.STRING).toString();
    private static final String phone = JSONDataManager.getJSONData(jsonFilePath, "phone", JSONDataManager.Types.STRING).toString();
    private static final String userStatus = JSONDataManager.getJSONData(jsonFilePath, "userStatus", JSONDataManager.Types.STRING).toString();

    private static Response response;

    public static void invokePostUserEndpointWithValidKey() {
        PostUsers_Req postUsersReq = new PostUsers_Req();
        postUsersReq.setId(Integer.parseInt(id));
        postUsersReq.setUsername(username);
        postUsersReq.setFirstName(firstname);
        postUsersReq.setLastName(lastname);
        postUsersReq.setEmail(email);
        postUsersReq.setPassword(password);
        postUsersReq.setPhone(phone);
        postUsersReq.setUserStatus(Integer.parseInt(userStatus));

        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.POST_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .setBody(postUsersReq)
                        .setExpectedStatusCode(HttpStatus.SC_CREATED)
                        .sendRequest();

                ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        PostUsers_Res userName = response.as(PostUsers_Res.class);
        ScenarioContext.setContext(Context.USER_NAME, userName.getUsername());
        Log4JLogger.logINFO(PostUser.class,"USER NAME :\n" + ScenarioContext.getContext(Context.USER_NAME));

    }

    public static void invokePostUserEndpointWithInValidKey() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.POST_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsCorrectParameters()
    {
        PostUsers_Res postUserRes = response.as(new TypeRef<>() {});

        Assertions.hardAssert().assertNotNull(postUserRes.getId());
        Assertions.hardAssert().assertNotNull(postUserRes.getUsername());
        Assertions.hardAssert().assertNotNull(postUserRes.getFirstName());
        Assertions.hardAssert().assertNotNull(postUserRes.getLastName());
        Assertions.hardAssert().assertNotNull(postUserRes.getEmail());
        Assertions.hardAssert().assertNotNull(postUserRes.getPassword());
        Assertions.hardAssert().assertNotNull(postUserRes.getPhone());
        Assertions.hardAssert().assertNotNull(postUserRes.getUserStatus());

        Assertions.hardAssert().objectEquals(postUserRes.getId(),id);
        Assertions.hardAssert().objectEquals(postUserRes.getUsername(),username);
        Assertions.hardAssert().objectEquals(postUserRes.getFirstName(),firstname);
        Assertions.hardAssert().objectEquals(postUserRes.getLastName(),lastname);
        Assertions.hardAssert().objectEquals(postUserRes.getEmail(),email);
        Assertions.hardAssert().objectEquals(postUserRes.getPassword(),password);
        Assertions.hardAssert().objectEquals(postUserRes.getPhone(),phone);
        Assertions.hardAssert().objectEquals(postUserRes.getUserStatus(),userStatus);
    }
}