import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// From: Youtube https://www.youtube.com/watch?v=mkIliGAePBM
// REST Assured API testing Beginner Tutorial | Part 2 - How to test GET POST PUT PATCH and DELETE

public class Test_4_PATCH {

	@Test
	public void test_4_PATCH() {
		
		
		JSONObject request = new JSONObject();
		
		
		request.put("name", "Sigourney_Weaver's alien baby");
		request.put("job", "Caretaker");
		
		
		System.out.println(request);
//		or can use: System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().statusCode(200).
		log().all();
		
		
	}
	
}
