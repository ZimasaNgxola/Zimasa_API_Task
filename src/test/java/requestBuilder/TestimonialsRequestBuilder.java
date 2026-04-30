package requestBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadBuilder.TestimonialPayLoad;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;
import static requestBuilder.AdminRequestBuilder.adminToken;

public class TestimonialsRequestBuilder {

    static String testimonialId;

    public static Response createTestimonial(String title, String content, String rating, String isPublic){


        String apiPath = "/APIDEV/testimonials";
        Response response = given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + adminToken)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(TestimonialPayLoad.createTestimonialPayLoad(title, content, rating, isPublic))
                .when()
                .post()
                .then()
                .extract().response();
        testimonialId = response.jsonPath().getString("data.id");
        return response;
    }
}
