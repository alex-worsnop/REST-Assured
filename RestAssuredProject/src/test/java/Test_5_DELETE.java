import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

//	From: Youtube https://www.youtube.com/watch?v=mkIliGAePBM
// REST Assured API testing Beginner Tutorial | Part 2 - How to test GET POST PUT PATCH and DELETE

public class Test_5_DELETE {

	@Test
	public void test_5_deletet() {
		
		
		when().
		delete("https://reqres.in/api/users/2").
		then().statusCode(204).
		log().all();
		
		
	}
	
}