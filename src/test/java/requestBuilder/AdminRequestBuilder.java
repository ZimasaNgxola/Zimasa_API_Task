package requestBuilder;

import io.restassured.response.Response;
import payloadBuilder.UserPayLoad;

public class AdminRequestBuilder {

    public static String adminToken;


    public static Response adminLogin(){
        Response response = UserRequestBuilder.loginUser("admin@gmail.com", "@12345678");
        adminToken = response.jsonPath().getString("data.token");
        return response;
    }

}
