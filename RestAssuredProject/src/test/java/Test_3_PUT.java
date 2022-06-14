import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// Youtube" https://www.youtube.com/watch?v=mkIliGAePBM
// REST Assured API testing Beginner Tutorial | Part 2 - How to test GET POST PUT PATCH and DELETE

public class Test_3_PUT {

	@Test
	public void test_3_PUT() {
		
		
		JSONObject request = new JSONObject();
		
		
		request.put("name", "Sigourney_Weaver");
		request.put("job", "Relief_Teacher");
		
		
		System.out.println(request);
//		or can use: System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200).
		log().all();
		
		
	}
	

}

