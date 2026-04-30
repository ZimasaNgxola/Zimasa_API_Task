package payloadBuilder;

import org.json.simple.JSONObject;

public class TestimonialPayLoad {

    public static JSONObject createTestimonialPayLoad(String title, String content, String rating, String isPublic){
        JSONObject createTestimonial = new JSONObject();
        createTestimonial.put("title", title);
        createTestimonial.put("content",content);
        createTestimonial.put("rating", rating);
        createTestimonial.put("isPublic", isPublic);

        return createTestimonial;
    }
}
