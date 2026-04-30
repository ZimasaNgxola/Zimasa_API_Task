package requestBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadBuilder.UserPayLoad;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserRequestBuilder {

    static String userToken;

    public static Response loginUser(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(UserPayLoad.userLoginPayLoad(email, password))
                .post()
                .then()
                .extract().response();
        userToken = response.jsonPath().getString("data.token");
        return response;

    }
}
