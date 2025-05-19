package pages.api.users;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.context.Context;
import api.context.ScenarioContext;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.responses.Users.PutUsers_Res;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utiltites.assertions.Assertions;
import utiltites.readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Map;

public class DeleteUser {

    private static Response response;
    private static final Map<String, String> queryParam = new HashMap<>();


    public static void invokeDeleteUserEndpointWithValidKey(String userName_Param) {
        queryParam.put("userName",userName_Param);


        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.DELETE)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.DELETE_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeDeleteUserEndpointWithInValidKey() {
        queryParam.put("username","eq!!2");


        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.DELETE)
                        .setBaseUri(BaseURI.PETSTORE_BASE.getBaseURI())
                        .setBasePath(BasePath.DELETE_USER.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParam)
                        .sendRequest();

        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }
}