package testimonialsTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloadBuilder.UserPayLoad;
import requestBuilder.AdminRequestBuilder;
import requestBuilder.TestimonialsRequestBuilder;

public class TestimonialTests {

    static String title;
    static String content;
    static String rating;
    static String isPublic;
    static String adminEmail;
    static String adminPassword;

    @BeforeClass
    public static void setUpData(){
        title = "Testing with Zimasa";
        content = "Automation API";
        rating = "4";
        isPublic = "true";
        adminEmail = "admin@gmail.com";
        adminPassword = "@12345678";
    }

    @Test (priority = 1)
    public void adminLoginTest(){
        Response response = AdminRequestBuilder.adminLogin();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test (priority = 2)
    public void createTestimonialTest(){
        Response response = TestimonialsRequestBuilder.createTestimonial(title, content, rating, isPublic);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
