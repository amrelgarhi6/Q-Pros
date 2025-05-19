package pages.api.users;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.context.Context;
import api.context.ScenarioContext;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.requests.Users.PostUsers_Req;
import api.pojo.requests.Users.PutUsers_Req;
import api.pojo.responses.Users.PostUsers_Res;
import api.pojo.responses.Users.PutUsers_Res;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utiltites.assertions.Assertions;
import utiltites.readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Map;

public class PutUser {

    private static Response response;
    private static final Map<String, String> queryParam = new HashMap<>();

    private final static String jsonFilePath = ("src/test/resources/test_data/api/request/Users/PutUser.json");


    private static final String id = JSONDataManager.getJSONData(jsonFilePath, "id", JSONDataManager.Types.STRING).toString();
    private static final String username = JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString();
    private static final String firstname = JSONDataManager.getJSONData(jsonFilePath, "firstName", JSONDataManager.Types.STRING).toString();
    private static final String lastname = JSONDataManager.getJSONData(jsonFilePath, "lastName", JSONDataManager.Types.STRING).toString();
    private static final String email = JSONDataManager.getJSONData(jsonFilePath, "email", JSONDataManager.Types.STRING).toString();
    private static final String password = JSONDataManager.getJSONData(jsonFilePath, "password", JSONDataManager.Types.STRING).toString();
    private static final String phone = JSONDataManager.getJSONData(jsonFilePath, "phone", JSONDataManager.Types.STRING).toString();
    private static final String userStatus = JSONDataManager.getJSONData(jsonFilePath, "userStatus", JSONDataManager.Types.STRING).toString();

    public static void invokePutUserEndpointWithValidKey() {
        String userName_Param = ScenarioContext.getContext(Context.USER_NAME).toString();
        queryParam.put("username",userName_Param);

        PutUsers_Req putUsersReq = new PutUsers_Req();
        putUsersReq.setId(Integer.parseInt(id));
        putUsersReq.setUsername(username);
        putUsersReq.setFirstName(firstname);
        putUsersReq.setLastName(lastname);
        putUsersReq.setEmail(email);
        putUsersReq.setPassword(password);
        putUsersReq.setPhone(phone);
        putUsersReq.setUserStatus(Integer.parseInt(userStatus));

        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.PUT_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .setBody(putUsersReq)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePutUserEndpointWithInValidKey() {

        queryParam.put("username","????");

        PutUsers_Req putUsersReq = new PutUsers_Req();
        putUsersReq.setId(Integer.parseInt(id));
        putUsersReq.setUsername(username);
        putUsersReq.setFirstName(firstname);
        putUsersReq.setLastName(lastname);
        putUsersReq.setEmail(email);
        putUsersReq.setPassword(password);
        putUsersReq.setPhone(phone);
        putUsersReq.setUserStatus(Integer.parseInt(userStatus));

        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.PUT_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .setBody(putUsersReq)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadUpdatedCorrectly()
    {
        PutUsers_Res putUserRes = response.as(new TypeRef<>() {});


        Assertions.hardAssert().assertNotNull(putUserRes.getId());
        Assertions.hardAssert().assertNotNull(putUserRes.getUsername());
        Assertions.hardAssert().assertNotNull(putUserRes.getFirstName());
        Assertions.hardAssert().assertNotNull(putUserRes.getLastName());
        Assertions.hardAssert().assertNotNull(putUserRes.getEmail());
        Assertions.hardAssert().assertNotNull(putUserRes.getPassword());
        Assertions.hardAssert().assertNotNull(putUserRes.getPhone());
        Assertions.hardAssert().assertNotNull(putUserRes.getUserStatus());

        Assertions.hardAssert().objectEquals(putUserRes.getId(),id);
        Assertions.hardAssert().objectEquals(putUserRes.getUsername(),username);
        Assertions.hardAssert().objectEquals(putUserRes.getFirstName(),firstname);
        Assertions.hardAssert().objectEquals(putUserRes.getLastName(),lastname);
        Assertions.hardAssert().objectEquals(putUserRes.getEmail(),email);
        Assertions.hardAssert().objectEquals(putUserRes.getPassword(),password);
        Assertions.hardAssert().objectEquals(putUserRes.getPhone(),phone);
        Assertions.hardAssert().objectEquals(putUserRes.getUserStatus(),userStatus);


    }
}