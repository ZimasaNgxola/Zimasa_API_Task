package courseTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestBuilder.CoursesRequestBuilder;
import requestBuilder.TestimonialsRequestBuilder;
import testimonialsTests.TestimonialTests;

public class CoursesTest {

    @Test (priority = 5)
    public void getPublishedCourses(){
        Response response = CoursesRequestBuilder.getPublishedCourses();
        response.then().log().all();
    }
}
